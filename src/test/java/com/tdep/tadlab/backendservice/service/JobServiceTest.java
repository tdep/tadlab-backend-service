package com.tdep.tadlab.backendservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tdep.tadlab.backendservice.data.connections.DBConnectionProvider;
import com.tdep.tadlab.backendservice.data.dto.Job;
import com.tdep.tadlab.backendservice.data.dto.Job.JobBuilder;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testcontainers.containers.PostgreSQLContainer;

@ExtendWith(MockitoExtension.class)
public class JobServiceTest {

  static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

  JobService jobService;

  @BeforeAll
  static void beforeAll() {
    postgres.start();
  }

  @AfterAll
  static void afterAll() {
    postgres.stop();
  }

  @BeforeEach
  void setUp() {
    DBConnectionProvider connectionProvider = new DBConnectionProvider(
        postgres.getJdbcUrl(),
        postgres.getUsername(),
        postgres.getPassword()
    );
    jobService = new JobService(connectionProvider);
  }
  @Test
  void testGetAllJobs() {
    jobService.createJob(new JobBuilder(1000, "Blorp", "Yesterday", "Today").build());
    jobService.createJob(new JobBuilder(1001, "Jorb", "Today", "Tomorrow").build());

    List<Job> jobs = jobService.getAllJobs();
    assertEquals(3, jobs.size());
  }

  @Test
  void testCreateJob() {
    final int ID = 1002;
    final String NAME = "Blorbl";
    final String START = "1892";
    final String END = "Fortuna";

    jobService.createJob(new JobBuilder(ID, NAME, START, END).build());

    assertEquals(ID, jobService.getJob(ID).getJobId());
    assertEquals(NAME, jobService.getJob(ID).getName());
    assertEquals(START, jobService.getJob(ID).getStartDate());
    assertEquals(END, jobService.getJob(ID).getEndDate());
  }

  @Test
  void testGetJob() {
    final int ID = 1003;
    final String NAME = "Jlog";
    final String START = "Whenev";
    final String END = "Later";

    jobService.createJob(new JobBuilder(ID, NAME, START, END).build());

    Job result = jobService.getJob(1003);

    assertEquals(ID, result.getJobId());
    assertEquals(NAME, result.getName());
    assertEquals(START, result.getStartDate());
    assertEquals(END, result.getEndDate());
  }


  @Test
  void testUpdateJob() {
    Job first = new JobBuilder(1004, "torb", "5th", "of Never").build();
    Job updated = new JobBuilder(1004, "Torbor", "6th", "of Florbuary").build();
    jobService.createJob(first);
    int result = jobService.updateJob(updated);

    assertEquals(1, result);
  }

  @Test
  void testDeleteJob() {
    Job tempJob = new JobBuilder(1005, "Flurbo", "doesn't matter", "not long now").build();
    jobService.createJob(tempJob);
    int result = jobService.deleteJob(tempJob);

    assertEquals(1, result);
  }

}
