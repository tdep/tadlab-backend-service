package com.tdep.tadlab.backendservice.service;

import com.tdep.tadlab.backendservice.model.Job;
import java.util.List;

public interface JobService {
  Job saveJob(Job job);

  List<Job> getAllJobs();

  Job getJobById(int id);

  boolean deleteJob(int id);

  Job updateJob(Job job);
}
