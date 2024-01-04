package com.tdep.tadlab.backendservice.data.dto;

import java.sql.Date;

public class Job {
  private int jobId;
  private String name;
  private Date start_date;
  private Date end_date;

  public Job(int jobId, String name, Date start_date, Date end_date) {
    this.jobId = jobId;
    this.name = name;
    this.start_date = start_date;
    this.end_date = end_date;
  }

  @Override
  public String toString() {
    return "Job{" +
        "id=" + jobId +
        ", name='" + name + '\'' +
        ", start_date='" + start_date + '\'' +
        ", end_date='" + end_date + '\'' +
        '}';
  }

  public int getJobId() {
    return jobId;
  }

  public void setJobId(int jobId) {
    this.jobId = jobId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getStartDate() {
    return start_date;
  }

  public void setStart_date(Date start_date) {
    this.start_date = start_date;
  }

  public Date getEndDate() {
    return end_date;
  }

  public void setEnd_date(Date end_date) {
    this.end_date = end_date;
  }

  public boolean isEmpty() { return name.isEmpty(); }
}
