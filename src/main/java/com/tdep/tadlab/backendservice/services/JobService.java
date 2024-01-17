package com.tdep.tadlab.backendservice.services;

import com.tdep.tadlab.backendservice.models.Job;
import com.tdep.tadlab.backendservice.repositories.JobRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
  private final JobRepository jobRepository;

  @Autowired
  public JobService(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
  }

  public List<Job> getJobs() {
    return jobRepository.findAll();
  }
}
