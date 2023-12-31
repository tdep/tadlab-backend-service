package com.tdep.tadlab.backendservice.data.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PgdbConnector {
  private static final Logger LOG = LoggerFactory.getLogger(PgdbConnector.class);

  private static final String PG_URL = System.getenv("POSTGRES_URL");
  private static final String PG_USER = System.getenv("POSTGRES_USER");
  private static final String PG_PWD = System.getenv("POSTGRES_PWD");

  public PgdbConnector() {
  }

  public static Connection connectDb() throws SQLException{
    Connection connection;
    connection = DriverManager.getConnection(PG_URL, PG_USER, PG_PWD);
    if (connection != null) {
      LOG.info("Successfully connected to the database!");
    }
    return connection;
  }
}
