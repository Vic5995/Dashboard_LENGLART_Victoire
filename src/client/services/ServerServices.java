package client.services;

import client.main.Main;
import model.ServerCommand;
import model.Student;

public class ServerServices {

  public static void authentification(String login, String password, IStudentListener listener) {
    String loginPassword = login + "/" + password;
    Thread t = new Thread(new ClientConnexion(Main.HOST, Main.PORT, listener, loginPassword));
    t.start();
  }

  public static void saveStudent(Student student, IStudentListener listener) {
    Thread t = new Thread(new ClientConnexion(Main.HOST, Main.PORT, listener, student));
    t.start();
  }

}
