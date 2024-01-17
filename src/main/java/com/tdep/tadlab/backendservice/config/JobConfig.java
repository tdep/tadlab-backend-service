package com.tdep.tadlab.backendservice.config;

import com.tdep.tadlab.backendservice.models.Job;
import com.tdep.tadlab.backendservice.repositories.JobRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {
  @Bean
  CommandLineRunner commandLineRunner(JobRepository repository) {
    return args -> {
      Job job1 = new Job(
          1,
          "Blorp",
          "Yesterday",
          "Today"
      );

      Job job2 = new Job(
          2,
          "Jorb",
          "Today",
          "Tomorrow"
      );
      repository.saveAll(List.of(job1, job2));
    };
  }
}
