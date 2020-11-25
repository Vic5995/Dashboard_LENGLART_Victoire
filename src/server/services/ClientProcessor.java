package server.services;

import model.ServerCommand;
import model.serverDataSet.FILDataSet;
import model.serverDataSet.FISEDataSet;
import model.serverDataSet.FITDataSet;
import model.serverDataSet.ServerDataSet;
import model.Student;
import server.dbTasks.ServerDataSetTask;
import server.dbTasks.StudentTask;
import utils.ConsoleColors;


import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientProcessor implements Runnable {
  private Socket socket;
  private ObjectOutputStream writer = null;
  private ObjectInputStream reader = null;

  public ClientProcessor(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    boolean closeConnexion = false;

    //tant que la connexion est active, on traite les demandes
    while (!socket.isClosed()) {

      try {
        writer = new ObjectOutputStream(socket.getOutputStream());
        reader = new ObjectInputStream(socket.getInputStream());

        //on attend la demande du client
        String response = read();
        System.out.println(ConsoleColors.CYAN + response + ConsoleColors.WHITE + "\n");
        InetSocketAddress remote = (InetSocketAddress)socket.getRemoteSocketAddress();

        //traitement de la demande client

        switch (response) {
          case ServerCommand.GET_STUDENT: {
            getStudent();
            closeConnexion = true;
            break;
          }
          case ServerCommand.POST_STUDENT: {
            saveStudent();
            closeConnexion = true;
            break;
          }
          case ServerCommand.GET_GENERAL: {
            getGeneral();
            closeConnexion = true;
            break;
          }
          case ServerCommand.GET_PROMOTIONS: {
            getPromotions();
            closeConnexion = true;
            break;
          }
          case ServerCommand.GET_FIL: {
            getFilDataSet();
            closeConnexion = true;
            break;
          }
          case ServerCommand.GET_FIT: {
            getFitDataSet();
            closeConnexion = true;
            break;
          }
          case ServerCommand.GET_FISE: {
            getFiseDataSet();
            closeConnexion = true;
            break;
          }
        }
        if (closeConnexion) {
          writer = null;
          reader = null;
          socket.close();
          break;
        }


      } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
        closeConnexion = true;
      }
    }
  }

  private void getStudent() throws IOException, ClassNotFoundException {
    String[] loginPassword = read().split("/");
    StudentTask task = new StudentTask();
    Student student = task.getStudent(loginPassword[0]);
    if (student != null) {
      if (student.getPassword().equals(loginPassword[1])) {
        writer.writeObject("OK");
        writer.flush();
        writer.writeObject(student);
        writer.flush();
      } else {
        writer.writeObject("Mot de passe erroné.");
        writer.flush();
      }
    } else {
      writer.writeObject("Étudiant inexistant.");
      writer.flush();
    }
  }

  private void saveStudent() throws IOException, ClassNotFoundException {
    Student student = (Student) reader.readObject();
    StudentTask task = new StudentTask();
    boolean success = task.updateStudent(student);
    if (success) {
      writer.writeObject("1");
    } else {
      writer.writeObject("0");
    }
    writer.flush();
  }

  private void getGeneral() throws IOException {
    System.out.println("Collecting datas...");
    ServerDataSetTask task = new ServerDataSetTask();
    ServerDataSet dataSet = task.getGeneralDataSet();
    if (dataSet != null) {
      writer.writeObject(dataSet);
      writer.flush();
      System.out.println("Datas Sent!");
    }
  }

  private void getPromotions() throws IOException {
    System.out.println("Collecting datas...");
    ServerDataSetTask task = new ServerDataSetTask();
    ServerDataSet dataSet = task.getPromotionDataSet();
    if (dataSet != null) {
      writer.writeObject(dataSet);
      writer.flush();
      System.out.println("Datas Sent!");
    }
  }

  private void getFilDataSet() throws IOException {
    System.out.println("Collecting datas...");
    ServerDataSetTask task = new ServerDataSetTask();
    FILDataSet dataSet = task.getFILDataSet();
    if (dataSet != null) {
      writer.writeObject(dataSet);
      writer.flush();
      System.out.println("Datas Sent!");
    }
  }

  private void getFitDataSet() throws IOException {
    System.out.println("Collecting datas...");
    ServerDataSetTask task = new ServerDataSetTask();
    FITDataSet dataSet = task.getFITDataSet();
    if (dataSet != null) {
      writer.writeObject(dataSet);
      writer.flush();
      System.out.println("Datas Sent!");
    }
  }

  private void getFiseDataSet() throws IOException {
    System.out.println("Collecting datas...");
    ServerDataSetTask task = new ServerDataSetTask();
    FISEDataSet dataSet = task.getFISEDataSet();
    if (dataSet != null) {
      writer.writeObject(dataSet);
      writer.flush();
      System.out.println("Datas Sent!");
    }
  }

  //méthode pour la lecture des réponses
  private String read() throws IOException, ClassNotFoundException {
    return (String) reader.readObject();
  }
}
