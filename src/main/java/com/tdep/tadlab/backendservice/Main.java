package com.tdep.tadlab.backendservice;

import com.tdep.tadlab.backendservice.data.connections.PgdbConnector;
import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
public class Main {
  private static final Logger LOG = LoggerFactory.getLogger(Main.class);


  public static void main(String[] args) throws Exception{
    Connection connection = PgdbConnector.connectDb();


    String sql = "SELECT name FROM job WHERE id=3";
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    rs.next();
    String name = rs.getString(1);
    System.out.println(name);
    connection.close();

    try {
      SpringApplication.run(Main.class, args);
    } catch (Exception e) {
      LOG.info(e.getMessage());
      System.out.println(e.getMessage());
    }
  }
}
