package server.services;

import model.ServerCommand;
import model.Student;
import server.dbTasks.StudentTask;


import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientProcessor implements Runnable {
  private Socket socket;
  private PrintWriter writer = null;
  private ObjectOutputStream objectWriter = null;
  private BufferedInputStream reader = null;
  private ObjectInputStream objectReader = null;

  public ClientProcessor(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    boolean closeConnexion = false;

    //tant que la connexion est active, on traite les demandes
    while (!socket.isClosed()) {

      try {
        objectWriter = new ObjectOutputStream(socket.getOutputStream());
        objectReader = new ObjectInputStream(socket.getInputStream());
        writer = new PrintWriter(socket.getOutputStream());
        reader = new BufferedInputStream(socket.getInputStream());

        //on attend la demande du client
        String response = read();
        System.out.println(response +"\n");
        InetSocketAddress remote = (InetSocketAddress)socket.getRemoteSocketAddress();

        //traitement de la demande client

        switch (response) {
          case ServerCommand.GET_STUDENT: {
            getStudent();
            closeConnexion = true;
            break;
          }
          case ServerCommand.SAVE_STUDENT: {
            saveStudent();
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
      }
    }
  }

  private void getStudent() throws IOException {
    writer.write("waiting for login...");
    writer.flush();
    String[] loginPassword = read().split("/");
    StudentTask task = new StudentTask();
    Student student = task.getStudent(loginPassword[0]);
    if (student != null) {
      if (student.getPassword().equals(loginPassword[1])) {
        writer.write("OK");
        writer.flush();
        objectWriter.writeObject(student);
        objectWriter.flush();
      } else {
        writer.write("Mot de passe erroné.");
        writer.flush();
      }
    } else {
      writer.write("Étudiant inexistant.");
      writer.flush();
    }
  }

  private void saveStudent() throws IOException, ClassNotFoundException {
    writer.write("waiting for student...");
    writer.flush();
    Student student = (Student)objectReader.readObject();
    StudentTask task = new StudentTask();
    boolean success = task.updateStudent(student);
    if (success) {
      writer.write("1");
    } else {
      writer.write("0");
    }
    writer.flush();
  }

  //méthode pour la lecture des réponses
  private String read() throws IOException{
    String response = "";
    int stream;
    byte[] b = new byte[4096];
    stream = reader.read(b);
    response = new String(b, 0, stream);
    return response;
  }
}
