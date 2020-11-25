package server.dbTasks;

import model.State;
import model.Student;

import java.sql.*;

public class StudentTask {
  private Connection connection;

  private void loadDatabase() {
    // Chargement du driver
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    try {
      connection = DriverManager.getConnection("jdbc:sqlite:dashboard.db", "root", "");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Student getStudent(String mLogin) {
    loadDatabase();
    Student student = null;

    //connexion à la base
    ResultSet results = null;

    try {
      //exécution de la requête
      PreparedStatement lookingForUser =
        connection.prepareStatement("SELECT * FROM student WHERE login = ?;");
      lookingForUser.setString(1, mLogin);
      results = lookingForUser.executeQuery();

      //récupération des données
      while(results.next()) {
        int id_student = results.getInt("id_student");
        String lastname = results.getString("lastname");
        String firstname = results.getString("firstname");
        String password = results.getString("_password");
        int prom = results.getInt("promotion");
        int state = results.getInt("state");
        String comment = results.getString("_comment");
        //TODO modifier pour acquisition du groupe
        student = new Student(id_student, mLogin, lastname, firstname, password, prom, 0, State.getStateFromId(state), comment);
      }
    } catch(SQLException s) {
      System.out.println(s.getMessage());
    } finally {
      //fermeture de connexion
      try {
        if(results != null) { results.close(); }
        if(connection != null) { connection.close(); }
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
    }
    return student;
  }

  public boolean updateStudent(Student student) {
    loadDatabase();
    boolean executedCorrectly = false;

    try {
      //exécution de la requête
      PreparedStatement update =
        connection.prepareStatement("UPDATE student SET state=?, _comment=? WHERE id_student=?;");
      update.setInt(1, student.getState().getId());
      update.setString(2, student.getComment());
      update.setInt(3, student.getId());

      int result = update.executeUpdate();
      if (result == 1) executedCorrectly = true;
    } catch(SQLException s) {
      System.out.println(s.getMessage());
    } finally {
      //fermeture de connexion
      try {
        if(connection != null) { connection.close(); }
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
    }
    return executedCorrectly;
  }


}
