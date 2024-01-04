package com.tdep.tadlab.backendservice.service.utils;

import com.tdep.tadlab.backendservice.data.connections.PgdbConnector;
import java.sql.Connection;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Connector {

  private static final Logger LOG = LoggerFactory.getLogger(Connector.class);

  public Connection openConnection() throws SQLException {
    try {
      return PgdbConnector.connectDb();
    } catch (SQLException e) {
      throw new SQLException(e.getMessage());
    }
  }

  public void closeConnection(Connection connection) throws SQLException {
    try {
      LOG.info("Connection closed.");
      connection.close();
    } catch (SQLException e) {
      LOG.info("Could not close database connection");
      throw new SQLException(e.getMessage());
    }
  }
}
