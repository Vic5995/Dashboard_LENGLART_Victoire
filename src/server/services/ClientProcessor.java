package server.services;

import dbTasks.StudentTask;
import model.Student;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientProcessor implements Runnable {

  private final String GET_STUDENT = "GETSTUDENT";
  private final String SAVE_STUDENT = "SAVESTUDENT";
  private final String GET_DATA = "GETDATA";

  private Socket socket;
  private PrintWriter writer = null;
  private BufferedInputStream reader = null;

  public ClientProcessor(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    boolean closeConnexion = false;

    //tant que la connexion est active, on traite les demandes
    while (!socket.isClosed()) {

      try {
        writer = new PrintWriter(socket.getOutputStream());
        reader = new BufferedInputStream(socket.getInputStream());

        //on attend la demande du client
        String response = read();
        System.out.println(response);
        InetSocketAddress remote = (InetSocketAddress)socket.getRemoteSocketAddress();

        //traitement de la demande client
        String toSend = "coucou";

        switch (response) {
          case GET_STUDENT: {
            writer.write("waiting for login...");
            writer.flush();
            String login = read();

            StudentTask task = new StudentTask();
            Student student = task.getStudent(login);

            String jsonStudent = (

            System.out.println(student.getFirstName());
            closeConnexion = true;
          }
        }

        writer.write(toSend);
        writer.flush();

        if (closeConnexion) {
          writer = null;
          reader = null;
          socket.close();
          break;
        }


      } catch (IOException e) {
        e.printStackTrace();
      }
    }
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
