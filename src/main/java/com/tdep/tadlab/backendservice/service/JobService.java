package com.tdep.tadlab.backendservice.service;

import com.tdep.tadlab.backendservice.data.connections.DBConnectionProvider;
import com.tdep.tadlab.backendservice.data.dao.JobDAOImpl;
import com.tdep.tadlab.backendservice.data.dto.Job;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobService {

  private final DBConnectionProvider connectionProvider;

  private static final Logger LOG = LoggerFactory.getLogger(JobService.class);

  public JobService(DBConnectionProvider connectionProvider) {
    this.connectionProvider = connectionProvider;
    createJobsTableIfNotExists();
  }

  JobDAOImpl jobDAO;

  public void createJob(Job job) {
    try (Connection connection = this.connectionProvider.getConnection()) {
      jobDAO = new JobDAOImpl(connection);
      jobDAO.insert(job);
      LOG.info("New Job created!");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Job getJob(int id) {
    Job job;
    try (Connection connection = this.connectionProvider.getConnection()) {
      jobDAO = new JobDAOImpl(connection);
      job = jobDAO.get(id);
    } catch (SQLException e) {
      LOG.info("Unable to fetch job with that id.");
      throw new RuntimeException(e);
    }
    return job;
  }

  public List<Job> getAllJobs() {
    try (Connection connection = this.connectionProvider.getConnection()) {
      jobDAO = new JobDAOImpl(connection);
      return jobDAO.getAll();
    } catch (SQLException e) {
      LOG.info("Something went wrong, unable to fetch jobs.");
      throw new RuntimeException(e);
    }
  }

  public int updateJob(Job job) {
    try(Connection connection = this.connectionProvider.getConnection()) {
      jobDAO = new JobDAOImpl(connection);
      return jobDAO.update(job);
    } catch (SQLException e) {
      LOG.info("Unable to update that job.");
      throw new RuntimeException(e);
    }
  }

  public int deleteJob(Job job) {
    try(Connection connection = this.connectionProvider.getConnection()) {
      jobDAO = new JobDAOImpl(connection);
      return jobDAO.delete(job);
    } catch (SQLException e) {
      LOG.info("Cannot delete this job.");
      throw new RuntimeException(e);
    }
  }

  private void createJobsTableIfNotExists() {
    try (Connection connection = this.connectionProvider.getConnection()) {
      jobDAO = new JobDAOImpl(connection);
      jobDAO.createTable();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
