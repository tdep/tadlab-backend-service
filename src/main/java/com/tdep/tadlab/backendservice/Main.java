package com.tdep.tadlab.backendservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.tdep.tadlab.backendservice.repository")
@SpringBootApplication()
public class Main {
  private static final Logger LOG = LoggerFactory.getLogger(Main.class);
  public static void main(String[] args) throws Exception{

    try {
      SpringApplication.run(Main.class, args);
    } catch (Exception e) {
      LOG.info(e.getMessage());
      System.out.println(e.getMessage());
    }
  }
}


//TODO: How to prevent creating two objects with the same name - in the DB or controller?
//TODO: Is there a better way to create a data layer? - Maybe without using Spring @Annotations
//TODO: Implementing Authentication to prevent outside calls without token
//TODO: Best way to handle ID generation
//TODO: Test endpoints using deployed service
//TODO: Create interface to handle editing and creating database entries
