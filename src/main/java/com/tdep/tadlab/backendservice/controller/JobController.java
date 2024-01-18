package com.tdep.tadlab.backendservice.controller;

import com.tdep.tadlab.backendservice.model.Job;
import com.tdep.tadlab.backendservice.service.JobService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class JobController {
  private final JobService jobService;

  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  @PostMapping("/job")
  public Job saveJob(@RequestBody Job job) {
    return jobService.saveJob(job);
  }

  @GetMapping("/jobs")
  public List<Job> getAllJobs() {
    return jobService.getAllJobs();
  }

  @GetMapping("/jobs/{id}")
  public ResponseEntity<Job> getJobById(@PathVariable("id") int id) {
    Job job = null;
    job = jobService.getJobById(id);
    return ResponseEntity.ok(job);
  }

  @DeleteMapping("/jobs/{id}")
  public ResponseEntity<Map<String,Boolean>> deleteJob(@PathVariable("id") int id) {
    boolean deleted = false;
    deleted = jobService.deleteJob(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", deleted);
    return ResponseEntity.ok(response);
  }

  @PutMapping("/jobs/{id}")
  public ResponseEntity<Job> updateJob(@PathVariable("id") int id, @RequestBody Job job) {
    jobService.getJobById(id);
    jobService.updateJob(job);
    return ResponseEntity.ok(job);
  }

  @RequestMapping("/")
  public @ResponseBody String greeting() {
    return "Hello, World";
  }
}
