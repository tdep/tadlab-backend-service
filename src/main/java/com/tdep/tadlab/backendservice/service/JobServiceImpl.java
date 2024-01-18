package com.tdep.tadlab.backendservice.service;

import com.tdep.tadlab.backendservice.entity.JobEntity;
import com.tdep.tadlab.backendservice.model.Job;
import com.tdep.tadlab.backendservice.repository.JobRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
  private final JobRepository jobRepository;

  public JobServiceImpl(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
  }

  @Override
  public Job saveJob(Job job) {
    JobEntity jobEntity = new JobEntity();
    BeanUtils.copyProperties(job, jobEntity);
    jobRepository.save(jobEntity);
    return job;
  }

  @Override
  public List<Job> getAllJobs() {
    List<JobEntity> jobEntities = jobRepository.findAll();

    return jobEntities
        .stream()
        .map(jobEntity -> new Job(
            jobEntity.getId(),
            jobEntity.getName(),
            jobEntity.getStartDate(),
            jobEntity.getEndDate()
        ))
        .collect(Collectors.toList());
  }

  @Override
  public Job getJobById(int id) {
    if (jobRepository.findById(id).isEmpty()) {
      throw new RuntimeException("Unable to find Job with that ID");
    } else {
      JobEntity jobEntity = jobRepository.findById(id).get();
      Job job = new Job();
      BeanUtils.copyProperties(jobEntity, job);
      return job;
    }
  }

  @Override
  public boolean deleteJob(int id) {
    if (jobRepository.findById(id).isPresent()) {
      JobEntity job = jobRepository.findById(id).get();
      jobRepository.delete(job);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void updateJob(Job job) {
    if (jobRepository.findById(job.getId()).isPresent()) {
      JobEntity jobEntity = jobRepository.findById(job.getId()).get();
      jobEntity.setName(job.getName());
      jobEntity.setStartDate(job.getStartDate());
      jobEntity.setEndDate(job.getEndDate());

    jobRepository.save(jobEntity);
    }

  }
}
