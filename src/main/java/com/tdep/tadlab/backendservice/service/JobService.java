package com.tdep.tadlab.backendservice.service;

import com.tdep.tadlab.backendservice.data.dao.JobDAO;
import com.tdep.tadlab.backendservice.data.dao.JobDAOImpl;
import com.tdep.tadlab.backendservice.data.dto.Job;
import com.tdep.tadlab.backendservice.service.utils.Connector;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobService {

  private final Connector connector;

  private static final Logger LOG = LoggerFactory.getLogger(JobService.class);

  public JobService(
      final Connector connector) {
    this.connector = connector;
  }

  public Job getJob(int id) throws SQLException {
    Connection connection = connector.openConnection();
    JobDAO jobDAO = new JobDAOImpl();
    Job job;
    try {
      job = jobDAO.get(id);
    } catch (SQLException e) {
      LOG.info("There are no jobs with that id.");
      throw new SQLException(e.getMessage());
    }
    connector.closeConnection(connection);
    return job;
  }

  public List<Job> getAllJobs() throws SQLException {
    // TODO: Add pagination and next token somehow
    Connection connection = connector.openConnection(); // this is causing the connection to be created twice I think
    JobDAO jobDAO = new JobDAOImpl();
    List<Job> jobsList = new ArrayList<>();
    try {
      jobDAO.getAll().stream()
          .map(
              jobs -> {
                Job job = // Each Job is being built twice - once in JobDAOImpl and once here, this should change
                    new Job(
                        jobs.getJobId(), jobs.getName(), jobs.getStartDate(), jobs.getEndDate());
                if (!job.isEmpty()) {
                  jobsList.add(job);
                }
                return job;
              })
          .collect(Collectors.toList());
    } catch (SQLException e) {
      LOG.info("Something went wrong, unable to fetch jobs.");
      throw new SQLException(e.getMessage());
    }
    connector.closeConnection(connection);
    return jobsList;
  }

  public Job addJob(int jobId, String name, String startDate, String endDate) throws SQLException{
    Connection connection = connector.openConnection();
    JobDAO jobDAO = new JobDAOImpl();
    Job job;
    try {
      jobDAO.insert(job = new Job(jobId, name, startDate, endDate));
      LOG.info(String.format("Added: %s", job));
    } catch (SQLException e) {
      LOG.info("Unable to create new job, check that all fields are entered correctly.");
      throw  new SQLException(e.getMessage());
    }
    connector.closeConnection(connection);
    return job;
  }

  public Job updateJob(int jobId, String name, String startDate, String endDate) throws SQLException{
    Connection connection = connector.openConnection();
    JobDAO jobDAO = new JobDAOImpl();
    Job job = new Job(jobId, name, startDate, endDate);

    try {
      if (!jobDAO.get(jobId).isEmpty()) {
        jobDAO.update(job);
        LOG.info(String.format("Updated: %s", job));
      }
    } catch (SQLException e) {
      LOG.info("Unable to update this job, try again or check for errors.");
      throw new SQLException(e.getMessage());
    }
    connector.closeConnection(connection);
    return job;
  }

  public Job deleteJob(int jobId) throws SQLException {
    Connection connection = connector.openConnection();
    JobDAO jobDAO = new JobDAOImpl();
    Job job;
    try {
      job = jobDAO.get(jobId);
      jobDAO.delete(job);
      LOG.info(String.format("Deleted: %s", job));
    } catch (SQLException e) {
      LOG.info("Something went wrong, unable to delete this job.");
      throw new SQLException(e.getMessage());
    }
    connector.closeConnection(connection);
    return job;
  }
}
