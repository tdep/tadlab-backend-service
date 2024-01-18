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
//  private static final String PG_URL = System.getenv("POSTGRES_URL");
//  private static final String PG_USER = System.getenv("POSTGRES_USER");
//  private static final String PG_PWD = System.getenv("POSTGRES_PWD");

  public static void main(String[] args) throws Exception{

    try {
      SpringApplication.run(Main.class, args);
    } catch (Exception e) {
      LOG.info(e.getMessage());
      System.out.println(e.getMessage());
    }
  }
}
