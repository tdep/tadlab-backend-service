package com.tdep.tadlab.backendservice;


import com.tdep.tadlab.backendservice.controllers.SampleApplicationController;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
  private static Connection getConnection() throws URISyntaxException, SQLException {
    String dbUrl = System.getenv("JDBC_DATABASE_URL");
    return DriverManager.getConnection(dbUrl);
  }

  public static void main(String[] args) throws Exception {

    try{
      SpringApplication.run(Main.class, args);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }

  }
}
