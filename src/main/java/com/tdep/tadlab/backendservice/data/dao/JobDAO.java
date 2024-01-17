package com.tdep.tadlab.backendservice.data.dao;

import com.tdep.tadlab.backendservice.models.Job;
import java.sql.SQLException;
import java.util.List;

public interface JobDAO extends DAO<Job> {
  Job get(int jobId) throws SQLException;

  List<Job> getAll() throws SQLException;

  void insertOrUpdate(Job job) throws SQLException;

  void delete(int jobId) throws SQLException;
}
