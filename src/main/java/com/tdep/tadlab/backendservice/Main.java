package com.tdep.tadlab.backendservice;

import com.tdep.tadlab.backendservice.data.connections.PgdbConnector;
import com.tdep.tadlab.backendservice.data.dao.JobDAO;
import com.tdep.tadlab.backendservice.data.dao.JobDAOImpl;
import com.tdep.tadlab.backendservice.data.ddl.TableBuilder;
import com.tdep.tadlab.backendservice.data.dto.Job;
import com.tdep.tadlab.backendservice.service.JobService;
import com.tdep.tadlab.backendservice.service.utils.Connector;
import java.sql.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
public class Main {
  private static final Logger LOG = LoggerFactory.getLogger(Main.class);


  public static void main(String[] args) throws Exception{

//    TableBuilder.build();

//    Connection connection = PgdbConnector.connectDb();
//
//
//    String sql = "SELECT name FROM job WHERE id=3";
//    Statement stmt = connection.createStatement();
//    ResultSet rs = stmt.executeQuery(sql);
//    rs.next();
//    String name = rs.getString(1);
//    System.out.println(name);
//    connection.close();
// ======
//    JobDAO jobDAO = new JobDAOImpl();
//
//    Job job = jobDAO.get(6);
//
//    System.out.println(job);
// ======
//    List<Job> jobs;
//
//    JobDAO jobDAO = new JobDAOImpl();
//
//    jobs = jobDAO.getAll();
//
//    for (Job job : jobs) {
//        System.out.println(job);
//    }
// ======
//    JobDAO jobDAO = new JobDAOImpl();
//
//    String str = "2023-04-04";
//
//    Date date = Date.valueOf(str);
//
//    Job job = new Job(0, "Blorpen", date, date);
//
//    int result = jobDAO.insert(job);
//
//    System.out.println(result);
// ======
//    JobDAO jobDAO = new JobDAOImpl();
//
//    Date date = Date.valueOf("2023-01-01");
//    Job job = new Job(9, "jorb", date, date);
//
//    jobDAO.update(job);
//
//    System.out.println(job);
// ======
//    JobDAO jobDAO = new JobDAOImpl();
//
//    Job job = jobDAO.get(9);
//
//    System.out.println(job);
//
//    int result = jobDAO.delete(job);
//
//    System.out.println(result);
    Connector connector = new Connector();
    JobService jobService = new JobService(connector);

    System.out.println(jobService.getJob(1));
    System.out.println(jobService.getAllJobs());
    System.out.println(jobService.addJob("Blorp","Blor", "Blo", "Bl"));

    try {
      SpringApplication.run(Main.class, args);
    } catch (Exception e) {
      LOG.info(e.getMessage());
      System.out.println(e.getMessage());
    }
  }
}
