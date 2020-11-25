package server.services;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServer {

  private int PORT;
  private String host = "127.0.0.1";
  private ServerSocket server = null;
  private boolean isRunning = true;

  public DataServer() {
    try {
      server = new ServerSocket(PORT, 100, InetAddress.getByName(host));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public DataServer(String host, int port) {
    this.PORT = port;
    this.host = host;
    try {
      server = new ServerSocket(PORT, 100, InetAddress.getByName(host));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //On lance le serveur
  public void open() {
    Thread t = new Thread(new Runnable() {
      @Override
      public void run() {

        while (isRunning) {
          try {
            //on attend la connexion du client
            Socket client = server.accept();
            System.out.println("Connexion cliente reçue.");

            //on traite la connexion reçue dans un thread séparé
            Thread t = new Thread(new ClientProcessor(client));
            t.start();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }

        try {
          server.close();
        } catch (IOException e) {
          e.printStackTrace();
          server = null;
        }
      }
    });

    t.start();
  }

  public void close() {
    isRunning = false;
  }
}
