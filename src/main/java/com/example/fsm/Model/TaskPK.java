package com.example.fsm.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TaskPK implements Serializable {
    private int taskId;
    private int projectId;

    @Column(name = "TASK_ID")
    @Id
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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
        TaskPK taskPK = (TaskPK) o;
        return taskId == taskPK.taskId &&
                projectId == taskPK.projectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, projectId);
    }
}
