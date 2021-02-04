package com.example.fsm.Model.Job;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Job {
    private int jobId;
    private String jobName;
    private Integer lowerSalaryLimit;
    private Integer upperSalaryLimit;

    @Id
    @Column(name = "JOB_ID")
    @GeneratedValue
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "JOB_NAME")
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Basic
    @Column(name = "LOWER_SALARY_LIMIT")
    public Integer getLowerSalaryLimit() {
        return lowerSalaryLimit;
    }

    public void setLowerSalaryLimit(Integer lowerSalaryLimit) {
        this.lowerSalaryLimit = lowerSalaryLimit;
    }

    @Basic
    @Column(name = "UPPER_SALARY_LIMIT")
    public Integer getUpperSalaryLimit() {
        return upperSalaryLimit;
    }

    public void setUpperSalaryLimit(Integer upperSalaryLimit) {
        this.upperSalaryLimit = upperSalaryLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return jobId == job.jobId &&
                Objects.equals(jobName, job.jobName) &&
                Objects.equals(lowerSalaryLimit, job.lowerSalaryLimit) &&
                Objects.equals(upperSalaryLimit, job.upperSalaryLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, jobName, lowerSalaryLimit, upperSalaryLimit);
    }
}
