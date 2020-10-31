package server;

import model.Prom;
import model.State;
import model.Student;

public class ServerServices {

  public static Student authentification(String login, String password) {
    //WARNING AsyncTask pour appel bdd
    return new Student(1, "login", "test", "test", "password", Prom.FITA1, State.PRESENT, "");
  }

}
