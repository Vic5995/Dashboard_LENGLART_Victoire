package client.services;

import client.main.Main;
import model.ServerCommand;
import model.Student;

import java.io.*;
import java.net.Socket;

public class ClientConnexion implements Runnable {
  private Socket connexion = null;
  private PrintWriter writer = null;
  private BufferedInputStream reader = null;
  private ObjectInputStream objectReader = null;
  private ObjectOutputStream objectWriter = null;

  private String command;
  private IStudentListener studentListener;
  private String loginPassword;
  private Student student;

  public ClientConnexion(String host, int port,
                         IStudentListener studentListener, String loginPassword) {
    this.studentListener = studentListener;
    this.command = ServerCommand.GET_STUDENT;
    this.loginPassword = loginPassword;
    try {
      connexion = new Socket(host, port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ClientConnexion(String host, int port,
                         IStudentListener studentListener, Student student) {
    this.studentListener = studentListener;
    this.command = ServerCommand.SAVE_STUDENT;
    this.student = student;
    try {
      connexion = new Socket(host, port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    try {
      writer = new PrintWriter(connexion.getOutputStream());
      reader = new BufferedInputStream(connexion.getInputStream());
      objectReader = new ObjectInputStream(connexion.getInputStream());
      objectWriter = new ObjectOutputStream(connexion.getOutputStream());

      writer.write(this.command);
      writer.flush();

      String response = read();

      switch (this.command) {
        case ServerCommand.GET_STUDENT : {
          writer.write(this.loginPassword);
          writer.flush();
          response = read();
          if (response.equals("OK")) {
            Student student = readStudent();
            studentListener.onReceivedStudent(student, response);
          } else {
            studentListener.onReceivedStudent(null, response);
          }
          break;
        }
        case ServerCommand.SAVE_STUDENT : {
          objectWriter.writeObject(student);
          objectWriter.flush();
          response = read();
          studentListener.onStudentSaved(response.equals("1"));
          break;
        }
      }
    } catch (IOException | ClassNotFoundException e) {
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

  private Student readStudent() throws IOException, ClassNotFoundException {
    return (Student)objectReader.readObject();
  }

}
