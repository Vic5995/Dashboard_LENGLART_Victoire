package client.services;

import client.main.ClientMain;
import model.Student;

/**
 * Classe : ServerServices
 *
 *  -> gestionnaire des différents services disponibles depuis le serveur
 *
 * @see client.main.Dashboard
 * @see client.main.Form
 * @see ClientConnexion
 */
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

  public static void getPromotionsDataSet(IDataSetListener listener) {
    ClientConnexion connexion = new ClientConnexion(ClientMain.HOST, ClientMain.PORT);
    connexion.configureForPromotionsDataSet(listener);
    Thread t = new Thread(connexion);
    t.start();
  }

  public static void getFILDataSet(IDataSetListener listener) {
    ClientConnexion connexion = new ClientConnexion(ClientMain.HOST, ClientMain.PORT);
    connexion.configureForFILDataSet(listener);
    Thread t = new Thread(connexion);
    t.start();
  }

  public static void getFITDataSet(IDataSetListener listener) {
    ClientConnexion connexion = new ClientConnexion(ClientMain.HOST, ClientMain.PORT);
    connexion.configureForFITDataSet(listener);
    Thread t = new Thread(connexion);
    t.start();
  }

  public static void getFISEDataSet(IDataSetListener listener) {
    ClientConnexion connexion = new ClientConnexion(ClientMain.HOST, ClientMain.PORT);
    connexion.configureForFISEDataSet(listener);
    Thread t = new Thread(connexion);
    t.start();
  }

  public static void getOnePromotion(IDataSetListener listener, int promId) {
    ClientConnexion connexion = new ClientConnexion(ClientMain.HOST, ClientMain.PORT);
    connexion.configureForOnePromotion(listener, promId);
    Thread t = new Thread(connexion);
    t.start();
  }
}
