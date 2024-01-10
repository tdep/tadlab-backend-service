package com.tdep.tadlab.backendservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.tdep.tadlab.backendservice.data.dao.JobDAO;
import com.tdep.tadlab.backendservice.data.dao.JobDAOImpl;
import com.tdep.tadlab.backendservice.data.dto.Job;
import com.tdep.tadlab.backendservice.data.dto.Job.JobBuilder;
import com.tdep.tadlab.backendservice.service.utils.Connector;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JobServiceTest {

  @Mock
  Connector connector;

  private JobService jobService;
  private JobDAO jobDAO;
  private static final int JOB_ID = 10000000;
  private static final String JOB_NAME = "Blorp's Test Job";
  private static final String JOB_START_DATE = "Jern 4th 1890";
  private static final String JOB_END_DATE = "Jorbuary nth 16-2";

  private static Job testJob;

 @BeforeEach
 public void setUp() {
   testJob = new JobBuilder(
       JOB_ID,
       JOB_NAME,
       JOB_START_DATE,
       JOB_END_DATE
   ).build();
   jobService = new JobService(connector);
   jobDAO = new JobDAOImpl();
 }

  @Test
  void testGetJob() throws SQLException {
   Job expected = new JobBuilder(JOB_ID, JOB_NAME, JOB_START_DATE, JOB_END_DATE)
       .build();

   when(jobDAO.get(JOB_ID)).thenReturn(expected);

   assertEquals(testJob, expected);
  }
}
