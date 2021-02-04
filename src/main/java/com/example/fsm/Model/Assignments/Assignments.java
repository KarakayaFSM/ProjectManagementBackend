package com.example.fsm.Model.Assignments;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(AssignmentsPK.class)
public class Assignments {
    private int resourceId;
    private int projectId;
    private Integer assignmentDuration;

    @Id
    @Column(name = "RESOURCE_ID")
    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Id
    @Column(name = "PROJECT_ID")
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "ASSIGNMENT_DURATION")
    public Integer getAssignmentDuration() {
        return assignmentDuration;
    }

    public void setAssignmentDuration(Integer assignmentDuration) {
        this.assignmentDuration = assignmentDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignments that = (Assignments) o;
        return resourceId == that.resourceId &&
                projectId == that.projectId &&
                Objects.equals(assignmentDuration, that.assignmentDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceId, projectId, assignmentDuration);
    }
}
