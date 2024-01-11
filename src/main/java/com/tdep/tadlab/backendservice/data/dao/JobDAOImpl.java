package com.tdep.tadlab.backendservice.data.dao;

import com.tdep.tadlab.backendservice.data.dto.Job;
import com.tdep.tadlab.backendservice.data.dto.Job.JobBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDAOImpl implements JobDAO{

  private final Connection connection;

  public JobDAOImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public int insert(Job job) throws SQLException {
    String sql = "INSERT INTO jobs (id, name, start_date, end_date) VALUES (?, ?, ?, ?)";

    PreparedStatement ps = connection.prepareStatement(sql);

    ps.setInt(1, job.getJobId());
    ps.setString(2, job.getName());
    ps.setString(3, job.getStartDate());
    ps.setString(4, job.getEndDate());

    // # of effected records
    return ps.executeUpdate();
  }

  @Override
  public Job get(int id) throws SQLException {
    Job job;
    String sql = "SELECT id, name, start_date, end_date FROM jobs WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
      int jobId = rs.getInt("id");
      String name = rs.getString("name");
      String start_date = rs.getString("start_date");
      String end_date = rs.getString("end_date");
      job = new JobBuilder(jobId, name, start_date, end_date).build();
    } else {
      throw new SQLException(String.valueOf(rs.wasNull()));
    }
    return job;
  }

  @Override
  public List<Job> getAll() throws SQLException {
// TODO: Add pagination and nextToken somehow
    List<Job> jobs = new ArrayList<>();
    String sql = "SELECT id, name, start_date, end_date FROM jobs";
    PreparedStatement ps = connection.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();

    while(rs.next()) {
      int id = rs.getInt("id");
      String name = rs.getString("name");
      String start_date = rs.getString("start_date");
      String end_date = rs.getString("end_date");
      jobs.add(new JobBuilder(id, name, start_date, end_date).build());
    }
    return jobs;
  }

  @Override
  public int update(Job job) throws SQLException {
    String sql = "UPDATE jobs set name = ?, start_date = ?, end_date = ? WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);

    ps.setString(1, job.getName());
    ps.setString(2, job.getStartDate());
    ps.setString(3, job.getEndDate());
    ps.setInt(4, job.getJobId());

    return ps.executeUpdate();
  }

  @Override
  public int delete(Job job) throws SQLException {
    String sql = "DELETE FROM jobs WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);

    ps.setInt(1, job.getJobId());

    return ps.executeUpdate();
  }

  @Override
  public int save(Job job) throws SQLException {
    return 0;
  }

  public void createTable() throws SQLException {
    String sql =
        """
      CREATE TABLE IF NOT EXISTS jobs (
      id BIGINT NOT NULL,
      name VARCHAR NOT NULL,
      start_date VARCHAR NOT NULL,
      end_date VARCHAR NOT NULL,
      PRIMARY KEY (id))
    """;

    PreparedStatement ps = connection.prepareStatement(sql);

    ps.execute();
  }
}
