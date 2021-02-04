package com.example.fsm.Model.Job;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "JOB_PREREQ")
@IdClass(JobPrereqPK.class)
public class JobPrereq {
    private int prereqId;
    private int jobId;

    @Id
    @Column
    public int getPrereqId() {
        return prereqId;
    }

    public void setPrereqId(int prereqId) {
        this.prereqId = prereqId;
    }

    @Id
    @Column
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
        JobPrereq jobPrereq = (JobPrereq) o;
        return prereqId == jobPrereq.prereqId &&
                jobId == jobPrereq.jobId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prereqId, jobId);
    }
}
