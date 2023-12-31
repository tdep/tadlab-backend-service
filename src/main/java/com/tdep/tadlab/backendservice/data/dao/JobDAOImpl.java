package com.tdep.tadlab.backendservice.data.dao;

import com.tdep.tadlab.backendservice.data.connections.PgdbConnector;
import com.tdep.tadlab.backendservice.data.dto.Job;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobDAOImpl implements JobDAO{

  @Override
  public Job get(int id) throws SQLException {
    Connection connection = PgdbConnector.connectDb();
    Job job = null;

    String sql = "SELECT id, name, start_date, end_date FROM job WHERE id = ?";

    PreparedStatement ps = connection.prepareStatement(sql);

    ps.setInt(1, id);

    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
      int jobId = rs.getInt("id");
      String name = rs.getString("name");
      String start_date = rs.getString("start_date");
      String end_date = rs.getString("end_date");

      job = new Job(jobId, name, start_date, end_date);
    }

    PgdbConnector.closeResultSet(rs);
    PgdbConnector.closePreparedStatement(ps);
    PgdbConnector.closeConnection(connection);

    return job;
  }

  @Override
  public List<Job> getAll() throws SQLException {

    Connection connection = PgdbConnector.connectDb();
    String sql = "SELECT id, name, start_date, end_date FROM job";

    List<Job> jobs = new ArrayList<>();

    Statement statement = connection.createStatement();

    ResultSet rs = statement.executeQuery(sql);

    while(rs.next()) {
      int jobId = rs.getInt("id");
      String name = rs.getString("name");
      String start_date = rs.getString("start_date");
      String end_date = rs.getString("end_date");

      Job job = new Job(jobId, name, start_date, end_date);

      jobs.add(job);
    }
    PgdbConnector.closeResultSet(rs);
    PgdbConnector.closeStatement(statement);
    PgdbConnector.closeConnection(connection);

    return jobs;
  }

  @Override
  public int save(Job job) throws SQLException {
    return 0;
  }

  @Override
  public int insert(Job job) throws SQLException {
    return 0;
  }

  @Override
  public int update(Job job) throws SQLException {
    return 0;
  }

  @Override
  public int delete(Job job) throws SQLException {
    return 0;
  }
}
