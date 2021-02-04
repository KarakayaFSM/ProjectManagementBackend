package com.example.fsm.Model.Job;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class JobPrereqPK implements Serializable {
    private int prereqId;
    private int jobId;

    @Column(name = "PREREQ_ID")
    @Id
    public int getPrereqId() {
        return prereqId;
    }

    public void setPrereqId(int prereqId) {
        this.prereqId = prereqId;
    }

    @Column(name = "JOB_ID")
    @Id
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobPrereqPK that = (JobPrereqPK) o;
        return prereqId == that.prereqId &&
                jobId == that.jobId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prereqId, jobId);
    }
}
