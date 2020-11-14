package client.services;

import client.main.Main;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientConnexion implements Runnable {
  private Socket connexion = null;
  private PrintWriter writer = null;
  private BufferedInputStream reader = null;

  private String command;
  private IStudentListener studentListener;
  private String login;

  public ClientConnexion(String host, int port, String command, IStudentListener studentListener, String login) {
    this.studentListener = studentListener;
    this.command = command;
    this.login = login;
    try {
      connexion = new Socket(host, port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    try {
      writer = new PrintWriter(connexion.getOutputStream(), true);
      reader = new BufferedInputStream(connexion.getInputStream());

      String toSend = this.command;
      writer.write(toSend);
      writer.flush();

      String response = read();
      System.out.println(response);

      switch (this.command) {
        case Main
          .GET_STUDENT : {
            writer.write(this.login);
            writer.flush();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String read() throws IOException {
    String response = "";
    int stream;
    byte[] b = new byte[4096];
    stream = reader.read(b);
    response = new String(b, 0, stream);
    return response;
  }

}
