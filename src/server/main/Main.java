package server.main;

import server.services.DataServer;

public class Main {
  public static final String HOST = "127.0.0.1";
  public static final int PORT = 2345;

  public static void main(String[] args) {
    DataServer server = new DataServer(HOST, PORT);
    server.open();
    System.out.println("Serveur initialisé");

  }
}
