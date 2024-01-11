package com.tdep.tadlab.backendservice;

import com.tdep.tadlab.backendservice.data.connections.DBConnectionProvider;
import com.tdep.tadlab.backendservice.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
public class Main {
  private static final Logger LOG = LoggerFactory.getLogger(Main.class);
  private static final String PG_URL = System.getenv("POSTGRES_URL");
  private static final String PG_USER = System.getenv("POSTGRES_USER");
  private static final String PG_PWD = System.getenv("POSTGRES_PWD");




  public static void main(String[] args) throws Exception{

    DBConnectionProvider connectionProvider = new DBConnectionProvider(
        PG_URL,
        PG_USER,
        PG_PWD
    );

    JobService jobService = new JobService(connectionProvider);
    //    jobService.createJob(new JobBuilder(3, "Blern", "Torp", "Lerp").build());
    System.out.println(jobService.deleteJob(jobService.getJob(3)));

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
//    Connector connector = new Connector();
//    JobService jobService = new JobService(connector);
//
//    jobService.getJob(7);
//    jobService.addJob(1000, "plorp", "yesterday", "today");
//    jobService.deleteJob(1000);

    try {
      SpringApplication.run(Main.class, args);
    } catch (Exception e) {
      LOG.info(e.getMessage());
      System.out.println(e.getMessage());
    }
  }
}
