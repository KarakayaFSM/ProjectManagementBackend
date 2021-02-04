package com.example.fsm.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
@IdClass(TaskPK.class)
public class Task {
    private int taskId;
    private String name;

    @Transient
    private Integer duration;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int projectId;

    @Id
    @Column(name = "TASK_ID")
    @GeneratedValue
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return Period.between(startDate, finishDate).getMonths();
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "START_DATE")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "FINISH_DATE")
    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    @Id
    @Column(name = "PROJECT_ID")
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
        Task task = (Task) o;
        return taskId == task.taskId &&
                projectId == task.projectId &&
                Objects.equals(name, task.name) &&
                Objects.equals(duration, task.duration) &&
                Objects.equals(startDate, task.startDate) &&
                Objects.equals(finishDate, task.finishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, name, duration, startDate, finishDate, projectId);
    }
}
