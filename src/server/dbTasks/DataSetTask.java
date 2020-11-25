package server.dbTasks;

import model.ServerDataSet;

import java.sql.*;

public class DataSetTask {
  private Connection connection;

  private final String SQL_GENERAL_SIZE = "SELECT COUNT(*) AS total FROM Student;";
  private final String SQL_GENERAL_PRESENT = "SELECT COUNT(*) AS total FROM Student WHERE state = 1;";
  private final String SQL_GENERAL_COVID = "SELECT COUNT(*) AS total FROM Student WHERE state = 2 OR state = 3;";
  private final String SQL_GENERAL_OTHER = "SELECT COUNT(*) AS total FROM Student WHERE state NOT IN (1, 2, 3);";
  private final String SQL_GENERAL_CAMPUS = "SELECT COUNT(*) AS total FROM Student WHERE state IN (1, 3, 5, 7, 9, 11);";
  private final String SQL_CONTACT_CASE = "SELECT COUNT(*) AS total FROM Student WHERE state IN (4, 5);";
  private final String SQL_PREVENTION = "SELECT COUNT(*) AS total FROM Student WHERE state IN (6, 7);";
  private final String SQL_SICK = "SELECT COUNT(*) AS total FROM Student WHERE state IN (8, 9);";
  private final String SQL_PRO = "SELECT COUNT(*) AS total FROM Student WHERE state IN (10, 11);";

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

}
