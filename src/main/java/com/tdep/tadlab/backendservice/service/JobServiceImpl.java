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
  private JobRepository jobRepository;

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

    List<Job> jobs = jobEntities
        .stream()
        .map(jobEntity -> new Job(
            jobEntity.getId(),
            jobEntity.getName(),
            jobEntity.getStartDate(),
            jobEntity.getEndDate()
        ))
        .collect(Collectors.toList());
    return jobs;
  }

  @Override
  public Job getJobById(Long id) {
    JobEntity jobEntity = jobRepository.findById(id).get();
    Job job = new Job();
    BeanUtils.copyProperties(jobEntity, job);
    return job;
  }

  @Override
  public boolean deleteJob(Long id) {
    JobEntity job = jobRepository.findById(id).get();
    jobRepository.delete(job);
    return true;
  }

  @Override
  public Job updateJob(Long id, Job job) {
    JobEntity jobEntity = jobRepository.findById(id).get();
    jobEntity.setName(job.getName());
    jobEntity.setStartDate(job.getStartDate());
    jobEntity.setEndDate(job.getEndDate());

    jobRepository.save(jobEntity);
    return job;
  }
}
