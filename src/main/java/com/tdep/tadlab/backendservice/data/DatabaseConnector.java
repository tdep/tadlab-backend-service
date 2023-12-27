package com.tdep.tadlab.backendservice.data;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

  public static void databaseConnector() throws Exception {
    Connection connection = getConnection();
    Statement stmt = connection.createStatement();
    stmt.executeUpdate("DROP TABLE IF EXISTS experience");
    stmt.executeUpdate("CREATE TABLE experience (name description)");
    stmt.executeUpdate("INSERT INTO experience VALUES (blorp descibed)");
    ResultSet rs = stmt.executeQuery("SELECT name FROM experience");
    while (rs.next()) {
      System.out.println("Read from DB: " + rs.getString("name"));
    }

  }

  private static Connection getConnection() throws URISyntaxException, SQLException {
    URI dbUri = new URI(System.getenv("DATABASE_URL"));

    String username = dbUri.getUserInfo().split(":")[0];
    String password = dbUri.getUserInfo().split(":")[1];
    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

    return DriverManager.getConnection(dbUrl, username, password);
  }

}
