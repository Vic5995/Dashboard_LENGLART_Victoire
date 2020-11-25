package client.services;

import client.main.ClientMain;
import model.Student;

public class ServerServices {

  public static void authentification(String login, String password, IStudentListener listener) {
    String loginPassword = login + "/" + password;
    ClientConnexion connexion = new ClientConnexion(ClientMain.HOST, ClientMain.PORT);
    connexion.configureForAuthentification(listener, loginPassword);
    Thread t = new Thread(connexion);
    t.start();
  }

  public static void saveStudent(Student student, IStudentListener listener) {
    ClientConnexion connexion = new ClientConnexion(ClientMain.HOST, ClientMain.PORT);
    connexion.configureForSavingStudent(listener, student);
    Thread t = new Thread(connexion);
    t.start();
  }

  public static void getGeneralDataSet(IDataSetListener listener) {
    ClientConnexion connexion = new ClientConnexion(ClientMain.HOST, ClientMain.PORT);
    connexion.configureForGeneralDataSet(listener);
    Thread t = new Thread(connexion);
    t.start();
  }

}
