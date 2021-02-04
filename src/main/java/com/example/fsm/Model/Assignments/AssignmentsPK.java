package com.example.fsm.Model.Assignments;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AssignmentsPK implements Serializable {
    private int resourceId;
    private int projectId;

    @Column(name = "RESOURCE_ID")
    @Id
    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Column(name = "PROJECT_ID")
    @Id
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignmentsPK that = (AssignmentsPK) o;
        return resourceId == that.resourceId &&
                projectId == that.projectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceId, projectId);
    }
}
