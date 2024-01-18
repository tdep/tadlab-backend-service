package com.tdep.tadlab.backendservice.service;

import com.tdep.tadlab.backendservice.model.Job;
import java.util.List;

public interface JobService {
  Job saveJob(Job job);

  List<Job> getAllJobs();

  Job getJobById(Long id);

  boolean deleteJob(Long id);

  Job updateJob(Long id, Job job);
}
