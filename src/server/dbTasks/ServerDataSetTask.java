package server.dbTasks;

import model.Promotion;
import model.State;
import model.Student;
import model.serverDataSet.FILDataSet;
import model.serverDataSet.FISEDataSet;
import model.serverDataSet.FITDataSet;
import model.serverDataSet.ServerDataSet;

import java.io.Serializable;
import java.sql.*;

public class ServerDataSetTask {
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

  private final String SQL_GENERAL_SIZE = "SELECT COUNT(*) AS total FROM Student;";
  private final String SQL_GENERAL_PRESENT = "SELECT COUNT(*) AS total FROM Student WHERE state = 1;";
  private final String SQL_GENERAL_COVID = "SELECT COUNT(*) AS total FROM Student WHERE state = 2 OR state = 3;";
  private final String SQL_GENERAL_OTHER = "SELECT COUNT(*) AS total FROM Student WHERE state NOT IN (1, 2, 3);";
  private final String SQL_GENERAL_CAMPUS = "SELECT COUNT(*) AS total FROM Student WHERE state IN (1, 3, 5, 7, 9, 11);";
  private final String SQL_CONTACT_CASE = "SELECT COUNT(*) AS total FROM Student WHERE state IN (4, 5);";
  private final String SQL_PREVENTION = "SELECT COUNT(*) AS total FROM Student WHERE state IN (6, 7);";
  private final String SQL_SICK = "SELECT COUNT(*) AS total FROM Student WHERE state IN (8, 9);";
  private final String SQL_PRO = "SELECT COUNT(*) AS total FROM Student WHERE state IN (10, 11);";

  public ServerDataSet getGeneralDataSet() {
    loadDatabase();
    ServerDataSet dataSet = null;

    ResultSet results = null;
    try {
      dataSet = new ServerDataSet();
      PreparedStatement statement = connection.prepareStatement(SQL_GENERAL_SIZE);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setGeneralTotal(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_GENERAL_PRESENT);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setGeneralPresent(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_GENERAL_COVID);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setGeneralPositive(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_GENERAL_OTHER);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setGeneralOther(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_GENERAL_CAMPUS);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setGeneralCampus(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_CONTACT_CASE);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setGeneralContactCase(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_PREVENTION);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setGeneralPrevention(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_SICK);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setGeneralSick(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_PRO);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setGeneralPro(results.getInt("total"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (results != null) { results.close();}
        if (connection != null) { results.close(); }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
    return dataSet;
  }

  private final String SQL_FIL_TOTAL = "SELECT COUNT(*) AS total FROM Student WHERE promotion IN (1, 2, 3);";
  private final String SQL_FIL_PRESENT = "SELECT COUNT(*) AS total FROM Student WHERE promotion IN (1, 2, 3) AND state = 1;";
  private final String SQL_FIL_COVID = "SELECT COUNT(*) AS total FROM Student WHERE promotion IN (1, 2, 3) AND state IN (2, 3);";
  private final String SQL_FIL_OTHER = "SELECT COUNT(*) AS total FROM Student WHERE promotion IN (1, 2, 3) AND state NOT IN (1, 2, 3);";

  private final String SQL_FIT_TOTAL = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 4;";
  private final String SQL_FIT_PRESENT = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 4 AND state = 1;";
  private final String SQL_FIT_COVID = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 4 AND state IN (2, 3);";
  private final String SQL_FIT_OTHER = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 4 AND state NOT IN (1, 2, 3);";

  private final String SQL_FISE_TOTAL = "SELECT COUNT(*) AS total FROM Student WHERE promotion IN (5, 6, 7);";
  private final String SQL_FISE_PRESENT = "SELECT COUNT(*) AS total FROM Student WHERE promotion IN (5, 6, 7) AND state = 1;";
  private final String SQL_FISE_COVID = "SELECT COUNT(*) AS total FROM Student WHERE promotion IN (5, 6, 7) AND state IN (2, 3);";
  private final String SQL_FISE_OTHER = "SELECT COUNT(*) AS total FROM Student WHERE promotion IN (5, 6, 7) AND state NOT IN (1, 2, 3);";

  public ServerDataSet getPromotionDataSet() {
    loadDatabase();
    ServerDataSet dataSet = null;

    ResultSet results = null;
    try {
      dataSet = new ServerDataSet();
      PreparedStatement statement = connection.prepareStatement(SQL_FIL_TOTAL);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setTotalFIL(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FIL_PRESENT);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setPresentFIL(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FIL_COVID);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setCovidFIL(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FIL_OTHER);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setOtherFIL(results.getInt("total"));
      }

      statement = connection.prepareStatement(SQL_FIT_TOTAL);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setTotalFIT(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FIT_PRESENT);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setPresentFIT(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FIT_COVID);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setCovidFIT(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FIT_OTHER);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setOtherFIT(results.getInt("total"));
      }

      statement = connection.prepareStatement(SQL_FISE_TOTAL);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setTotalFISE(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FISE_PRESENT);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setPresentFISE(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FISE_COVID);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setCovidFISE(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FISE_OTHER);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setOtherFISE(results.getInt("total"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (results != null) { results.close();}
        if (connection != null) { results.close(); }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
    return dataSet;
  }

  private final String SQL_FILA1_TOTAL = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 1;";
  private final String SQL_FILA1_PRESENT = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 1 AND state = 1;";
  private final String SQL_FILA1_COVID = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 1 AND state IN (2, 3);";
  private final String SQL_FILA1_OTHER = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 1 AND state NOT IN (1, 2, 3);";
  private final String SQL_FILA2_TOTAL = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 2;";
  private final String SQL_FILA2_PRESENT = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 2 AND state = 1;";
  private final String SQL_FILA2_COVID = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 2 AND state IN (2, 3);";
  private final String SQL_FILA2_OTHER = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 2 AND state NOT IN (1, 2, 3);";
  private final String SQL_FILA3_TOTAL = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 3;";
  private final String SQL_FILA3_PRESENT = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 3 AND state = 1;";
  private final String SQL_FILA3_COVID = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 3 AND state IN (2, 3);";
  private final String SQL_FILA3_OTHER = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 3 AND state NOT IN (1, 2, 3);";

  public FILDataSet getFILDataSet() {
    loadDatabase();
    FILDataSet dataSet = null;

    ResultSet results = null;
    try {
      dataSet = new FILDataSet();
      PreparedStatement statement = connection.prepareStatement(SQL_FILA1_TOTAL);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setTotalFILA1(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FILA1_PRESENT);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setPresentFILA1(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FILA1_COVID);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setCovidFILA1(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FILA1_OTHER);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setOtherFILA1(results.getInt("total"));
      }

      statement = connection.prepareStatement(SQL_FILA2_TOTAL);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setTotalFILA2(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FILA2_PRESENT);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setPresentFILA2(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FILA2_COVID);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setCovidFILA2(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FILA2_OTHER);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setOtherFILA2(results.getInt("total"));
      }

      statement = connection.prepareStatement(SQL_FILA3_TOTAL);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setTotalFILA3(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FILA3_PRESENT);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setPresentFILA3(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FILA3_COVID);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setCovidFILA3(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FILA3_OTHER);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setOtherFILA3(results.getInt("total"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (results != null) { results.close();}
        if (connection != null) { results.close(); }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
    return dataSet;
  }

  private final String SQL_FISEA1_TOTAL = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 5;";
  private final String SQL_FISEA1_PRESENT = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 5 AND state = 1;";
  private final String SQL_FISEA1_COVID = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 5 AND state IN (2, 3);";
  private final String SQL_FISEA1_OTHER = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 5 AND state NOT IN (1, 2, 3);";
  private final String SQL_FISEA2_TOTAL = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 6;";
  private final String SQL_FISEA2_PRESENT = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 6 AND state = 1;";
  private final String SQL_FISEA2_COVID = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 6 AND state IN (2, 3);";
  private final String SQL_FISEA2_OTHER = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 6 AND state NOT IN (1, 2, 3);";
  private final String SQL_FISEA3_TOTAL = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 7;";
  private final String SQL_FISEA3_PRESENT = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 7 AND state = 1;";
  private final String SQL_FISEA3_COVID = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 7 AND state IN (2, 3);";
  private final String SQL_FISEA3_OTHER = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 7 AND state NOT IN (1, 2, 3);";

  public FISEDataSet getFISEDataSet() {
    loadDatabase();
    FISEDataSet dataSet = null;

    ResultSet results = null;
    try {
      dataSet = new FISEDataSet();
      PreparedStatement statement = connection.prepareStatement(SQL_FISEA1_TOTAL);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setTotalFISEA1(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FISEA1_PRESENT);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setPresentFISEA1(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FISEA1_COVID);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setCovidFISEA1(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FISEA1_OTHER);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setOtherFISEA1(results.getInt("total"));
      }

      statement = connection.prepareStatement(SQL_FISEA2_TOTAL);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setTotalFISEA2(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FISEA2_PRESENT);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setPresentFISEA2(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FISEA2_COVID);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setCovidFISEA2(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FISEA2_OTHER);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setOtherFISEA2(results.getInt("total"));
      }

      statement = connection.prepareStatement(SQL_FISEA3_TOTAL);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setTotalFISEA3(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FISEA3_PRESENT);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setPresentFISEA3(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FISEA3_COVID);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setCovidFISEA3(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FISEA3_OTHER);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setOtherFISEA3(results.getInt("total"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (results != null) { results.close();}
        if (connection != null) { results.close(); }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
    return dataSet;
  }

  private final String SQL_FITA1_TOTAL = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 4;";
  private final String SQL_FITA1_PRESENT = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 4 AND state = 1;";
  private final String SQL_FITA1_COVID = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 4 AND state IN (2, 3);";
  private final String SQL_FITA1_OTHER = "SELECT COUNT(*) AS total FROM Student WHERE promotion = 4 AND state NOT IN (1, 2, 3);";

  public FITDataSet getFITDataSet() {
    loadDatabase();
    FITDataSet dataSet = null;

    ResultSet results = null;
    try {
      dataSet = new FITDataSet();
      PreparedStatement statement = connection.prepareStatement(SQL_FITA1_TOTAL);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setTotalFITA1(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FITA1_PRESENT);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setPresentFITA1(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FITA1_COVID);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setCovidFITA1(results.getInt("total"));
      }
      statement = connection.prepareStatement(SQL_FITA1_OTHER);
      results = statement.executeQuery();
      while (results.next()) {
        dataSet.setOtherFITA1(results.getInt("total"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (results != null) { results.close();}
        if (connection != null) { results.close(); }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
    return dataSet;
  }

  public Promotion getOnePromotion(int promId) {
    loadDatabase();
    Promotion promotion = new Promotion(promId);

    ResultSet results = null;

    try {
      //exécution de la requête
      PreparedStatement lookingForUser =
        connection.prepareStatement("SELECT * FROM student WHERE promotion = ?;");
      lookingForUser.setInt(1, promId);
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
        int englishGroup = results.getInt("englishGroup");
        String login = results.getString("login");
        Student student = new Student(id_student, login, lastname, firstname, password, prom, englishGroup, State.getStateFromId(state), comment);
        promotion.add(student);
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

    return promotion;
  }
}
