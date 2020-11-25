package client.services;

import model.ServerCommand;
import model.serverDataSet.FILDataSet;
import model.serverDataSet.FISEDataSet;
import model.serverDataSet.FITDataSet;
import model.serverDataSet.ServerDataSet;
import model.Student;

import java.io.*;
import java.net.Socket;

public class ClientConnexion implements Runnable {
  private Socket connexion = null;
  private ObjectInputStream reader = null;
  private ObjectOutputStream writer = null;

  private String command;
  private IStudentListener studentListener;
  private IDataSetListener dataSetListener;
  private String loginPassword;
  private Student student;

  public ClientConnexion(String host, int port) {
    try {
      connexion = new Socket(host, port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

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
      }
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

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
}
