package client.services;

import model.Promotion;
import model.ServerCommand;
import model.serverDataSet.FILDataSet;
import model.serverDataSet.FISEDataSet;
import model.serverDataSet.FITDataSet;
import model.serverDataSet.ServerDataSet;
import model.Student;

import java.io.*;
import java.net.Socket;

/**
 * Classe : ClientConnexion
 *
 *  -> permet de gérer les commandes passées au serveur en configurant les différents listeners et objets nécessaire
 *  à la bonne communication
 *
 * @see ServerCommand
 * @see ServerServices
 */
public class ClientConnexion implements Runnable {
  private Socket connexion = null;
  private ObjectInputStream reader = null;
  private ObjectOutputStream writer = null;

  private String command;
  private IStudentListener studentListener;
  private IDataSetListener dataSetListener;
  private String loginPassword;
  private Student student;
  private int promId;

  public ClientConnexion(String host, int port) {
    try {
      connexion = new Socket(host, port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /* =================================================
      CONFIGURATION SERVICES

      -> permettent les configations des listeners et des commandes à envoyées au serveur
      -> le cas échéant, permettent de stocker les données nécessaires à la récupération d'autres données
   ================================================ */

  public void configureForGeneralDataSet(IDataSetListener dataSetListener) {
    this.dataSetListener = dataSetListener;
    this.command = ServerCommand.GET_GENERAL;
  }

  public void configureForPromotionsDataSet(IDataSetListener dataSetListener) {
    this.dataSetListener = dataSetListener;
    this.command = ServerCommand.GET_PROMOTIONS;
  }

  public void configureForFILDataSet(IDataSetListener dataSetListener) {
    this.dataSetListener = dataSetListener;
    this.command = ServerCommand.GET_FIL;
  }

  public void configureForFITDataSet(IDataSetListener dataSetListener) {
    this.dataSetListener = dataSetListener;
    this.command = ServerCommand.GET_FIT;
  }

  public void configureForFISEDataSet(IDataSetListener dataSetListener) {
    this.dataSetListener = dataSetListener;
    this.command = ServerCommand.GET_FISE;
  }

  public void configureForAuthentification(IStudentListener studentListener, String loginPassword) {
    this.studentListener = studentListener;
    this.command = ServerCommand.GET_STUDENT;
    this.loginPassword = loginPassword;
  }

  public void configureForSavingStudent(IStudentListener studentListener, Student student) {
    this.studentListener = studentListener;
    this.command = ServerCommand.POST_STUDENT;
    this.student = student;
  }

  public void configureForOnePromotion(IDataSetListener dataSetListener, int promId) {
    this.dataSetListener = dataSetListener;
    this.promId = promId;
    this.command = ServerCommand.GET_ONE_PROMOTION;
  }

  @Override
  public void run() {
    try {
      writer = new ObjectOutputStream(connexion.getOutputStream());
      reader = new ObjectInputStream(connexion.getInputStream());

      writer.writeObject(this.command);
      writer.flush();

      String response = null;

      switch (this.command) {
        case ServerCommand.GET_STUDENT -> {
          writer.writeObject(this.loginPassword);
          writer.flush();
          response = read();
          if (response.equals("OK")) {
            Student student = readStudent();
            studentListener.onReceivedStudent(student, response);
          } else {
            studentListener.onReceivedStudent(null, response);
          }
        }
        case ServerCommand.POST_STUDENT -> {
          writer.writeObject(student);
          writer.flush();
          response = read();
          studentListener.onStudentSaved(response.equals("1"));
        }
        case ServerCommand.GET_GENERAL -> {
          ServerDataSet dataSet = readDataSet();
          dataSetListener.onReceivedGeneralDataSet(dataSet);
        }
        case ServerCommand.GET_PROMOTIONS -> {
          ServerDataSet dataSet = readDataSet();
          dataSetListener.onReveivedPromotionsDataSet(dataSet);
        }
        case ServerCommand.GET_FIL -> {
          FILDataSet dataSet = readFILDataSet();
          dataSetListener.onReceivedFILDataSet(dataSet);
        }
        case ServerCommand.GET_FIT -> {
          FITDataSet dataSet = readFITDataSet();
          dataSetListener.onReceivedFITDataSet(dataSet);
        }
        case ServerCommand.GET_FISE -> {
          FISEDataSet dataSet = readFISEDataSet();
          dataSetListener.onReceivedFISEDataSet(dataSet);
        }
        case ServerCommand.GET_ONE_PROMOTION -> {
          writer.writeObject(this.promId);
          writer.flush();
          Promotion promotion = readPromotion();
          dataSetListener.onReceivedPromotion(promotion);
        }
      }
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  /* =================================================
      READING SERVICES

      -> Permettent la lecture des différents objets renvoyés par le serveur
   ================================================ */

  private String read() throws IOException, ClassNotFoundException {
    return (String)reader.readObject();
  }

  private Student readStudent() throws IOException, ClassNotFoundException {
    return (Student) reader.readObject();
  }

  private ServerDataSet readDataSet() throws IOException, ClassNotFoundException {
    Object obj = reader.readObject();
    return (ServerDataSet)obj;
  }

  private FILDataSet readFILDataSet() throws IOException, ClassNotFoundException {
    return (FILDataSet)reader.readObject();
  }

  private FITDataSet readFITDataSet() throws IOException, ClassNotFoundException {
    return (FITDataSet)reader.readObject();
  }

  private FISEDataSet readFISEDataSet() throws IOException, ClassNotFoundException {
    return (FISEDataSet)reader.readObject();
  }

  private Promotion readPromotion() throws IOException,ClassNotFoundException {
    return (Promotion)reader.readObject();
  }
}
