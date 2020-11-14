package server.dbTasks;

import model.State;
import model.Student;

import java.sql.*;

public class StudentTask {
  private Connection connexion;

  public Student getStudent(String mLogin) {
    Student user = null;

    //chargement du driver
    try {
      Class.forName("org.sqlite.JDBC");
    } catch(ClassNotFoundException c) {
      System.out.println(c.getMessage());
    }

    //connexion à la base
    Connection connexion = null;
    Statement statement = null;
    ResultSet results = null;

    try {
      connexion = DriverManager.getConnection("jdbc:sqlite:dashboard.db", "root", "");

      //statement = connexion.createStatement();

      //exécution de la requête
      PreparedStatement lookingForUser =
        connexion.prepareStatement("SELECT * FROM student WHERE login = ?;");
      lookingForUser.setString(1, mLogin);
      results = lookingForUser.executeQuery();

      //récupération des données
      while(results.next()) {
        int id_student = results.getInt("id_student");
        String lastname = results.getString("lastname");
        String firstname = results.getString("firstname");
        String password = results.getString("_password");
        //String login = results.getString("login");
        int prom = results.getInt("promomotion");
        int state = results.getInt("state");
        String comment = results.getString("_comment");
        user = new Student(id_student, mLogin, lastname, firstname, password, prom, State.getStateFromId(state), comment);
      }
    } catch(SQLException s) {
      System.out.println(s.getMessage());
    } finally {

      //fermeture de connexion
      try {
        if(results != null) { results.close(); }
        if(statement != null) { statement.close(); }
        if(connexion != null) { connexion.close(); }
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
    }
    return user;
  }
}
