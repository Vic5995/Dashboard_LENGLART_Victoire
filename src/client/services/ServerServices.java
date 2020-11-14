package client.services;

import client.main.Main;
import model.Promotion;
import model.State;
import model.Student;

public class ServerServices {

  public static Student authentification(String login, String password, IStudentListener listener) {
    //WARNING AsyncTask pour appel bdd
    Thread t = new Thread(new ClientConnexion(Main.HOST, Main.PORT, Main.GET_STUDENT, listener, login));
    t.start();

    return new Student(1, "login", "test", "test", "password", Promotion.FITA1, State.PRESENT, "");
  }

}
