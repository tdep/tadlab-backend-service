package com.tdep.tadlab.backendservice;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
  public static void main(String[] args) throws Exception {
    Connection connection = getConnection();

    Statement stmt = connection.createStatement();
    stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
    stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
    stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
    ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
    while (rs.next()) {
      System.out.println("Read from DB: " + rs.getTimestamp("tick"));
    }

    try{
      SpringApplication.run(Main.class, args);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }

  }
  private static Connection getConnection() throws URISyntaxException, SQLException {
    String dbUrl = System.getenv("JDBC_DATABASE_URL");
    return DriverManager.getConnection(dbUrl);
  }
}
