package com.tdep.tadlab.backendservice.data.dto;


public class Job {
  private final int jobId;
  private final String name;
  private final String start_date;
  private final String end_date;

  public int getJobId() {
    return jobId;
  }
  public String getName() {
    return name;
  }
  public String getStartDate() {
    return start_date;
  }
  public String getEndDate() {
    return end_date;
  }
  public boolean isEmpty() { return name.isEmpty(); }

  private Job(JobBuilder builder) {
    this.jobId = builder.jobId;
    this.name = builder.name;
    this.start_date = builder.startDate;
    this.end_date = builder.endDate;
  }

  public static class JobBuilder {
    private final int jobId;
    private final String name;
    private final String startDate;
    private final String endDate;

    public JobBuilder(
        int jobId,
        String name,
        String startDate,
        String endDate) {
      this.jobId = jobId;
      this.name = name;
      this.startDate = startDate;
      this.endDate = endDate;
    }

    public Job build() {
      return new Job(this);
    }
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
}
