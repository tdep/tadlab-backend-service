package com.tdep.tadlab.backendservice.data.dto;

import java.sql.Date;

public class Job {
  private int id;
  private String name;
  private Date start_date;
  private Date end_date;

  public Job(int id, String name, Date start_date, Date end_date) {
    this.id = id;
    this.name = name;
    this.start_date = start_date;
    this.end_date = end_date;
  }

  @Override
  public String toString() {
    return "Job{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", start_date='" + start_date + '\'' +
        ", end_date='" + end_date + '\'' +
        '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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


}
