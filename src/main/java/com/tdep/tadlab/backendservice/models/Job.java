package com.tdep.tadlab.backendservice.models;


import java.sql.Date;

public class Job {
  private int jobId;
  private String name;
  private String startDate;
  private String endDate;

  public Job() {

  }

  public Job(int jobId, String name, String startDate, String endDate) {
    this.jobId = jobId;
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
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

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
}
