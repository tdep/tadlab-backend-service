package com.tdep.tadlab.backendservice.data.dao;

import com.tdep.tadlab.backendservice.models.Job;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JobDAOImpl implements JobDAO {

  private JdbcTemplate jdbcTemplate;

  public JobDAOImpl(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public Job get(int jobId) {
    String sql = "SELECT * FROM jobs WHERE id=" + jobId;
    return jdbcTemplate.query(sql, rs -> {
      if (rs.next()) {
        Job job = new Job();
        job.setJobId(rs.getInt("id"));
        job.setName(rs.getString("name"));
        job.setStartDate(rs.getString("start_date"));
        job.setEndDate(rs.getString("end_date"));
        return job;
      }
      return null;
    });
  }

  @Override
  public List<Job> getAll() {
    String sql = "SELECT * FROM jobs";
    List<Job> jobList = jdbcTemplate.query(sql, (rs, rowNum) -> {
      Job job = new Job ();

      job.setJobId(rs.getInt("id"));
      job.setName(rs.getString("name"));
      job.setStartDate(rs.getString("start_date"));
      job.setEndDate(rs.getString("end_date"));

      return job;
    });
    return jobList;
  }

  @Override
  public void insertOrUpdate(Job job) {
    if (job.getJobId() > 0) {
      String slq = "UPDATE jobs SET name=?, start_date=?, end_date=? WHERE id=?";
      jdbcTemplate.update(slq, job.getName(), job.getStartDate(), job.getEndDate());
    } else {
      String sql = "INSERT INTO jobs (id, name, start_date, end_date)" + "VALUES (?,?,?,?)";
      jdbcTemplate.update(sql, job.getJobId(), job.getName(), job.getStartDate(), job.getEndDate());
    }
  }

  @Override
  public void delete(Job job) throws SQLException {

  }

  @Override
  public void delete(int jobId) {
    String sql = "DELETE FROM jobs WHERE id=?";
    jdbcTemplate.update(sql, jobId);
  }
}
