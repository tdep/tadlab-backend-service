package com.tdep.tadlab.backendservice.data.ddl;

import com.tdep.tadlab.backendservice.data.connections.PgdbConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableBuilder {
  private static Connection connection = null;
  private static Statement statement = null;

  public static void build() throws SQLException {

    try {
      connection = PgdbConnector.connectDb();
      System.out.println("Table Builder Connected!");

      statement =  connection.createStatement();

      String sql = "CREATE TABLE IF NOT EXISTS users (id SERIAL NOT NULL, user_id VARCHAR(30) NOT NULL, PRIMARY KEY (id), UNIQUE (user_id))";

      statement.execute(sql);

    } catch (SQLException e) {
      e.printStackTrace();
    } finally{
      PgdbConnector.closeStatement(statement);
      PgdbConnector.closeConnection(connection);
      System.out.println("Table Build Finished Running!");
    }
  }
}
