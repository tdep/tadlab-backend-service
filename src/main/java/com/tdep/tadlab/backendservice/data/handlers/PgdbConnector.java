package com.tdep.tadlab.backendservice.data.handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Status;

public class PgdbConnector {
  private static final Logger LOG = LoggerFactory.getLogger(PgdbConnector.class);

  public final String PG_URL;
  public final String PG_USER;
  public final String PG_PWD;
  public PgdbConnector(final String dbUrl, final String dbUser, final String dbPwd) {
    this.PG_URL = dbUrl;
    this.PG_USER = dbUser;
    this.PG_PWD = dbPwd;
  }

  public Connection connectDb() throws RuntimeException{
    try {
      return DriverManager.getConnection(PG_URL, PG_USER, PG_PWD);
    } catch (SQLException e) {
      LOG.info(e.getMessage());
    }
    throw new RuntimeException(Status.DOWN.getCode());
  }
}
