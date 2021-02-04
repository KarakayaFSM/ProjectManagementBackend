package com.example.fsm.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Project {
    private int projectId;
    private String name;
    private Integer budget;
    private String description;
    private Integer managerId;
    private Integer duration;

    @Id
    @Column(name = "PROJECT_ID")
    @GeneratedValue
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "BUDGET")
    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "MANAGER_ID")
    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "DURATION")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectId == project.projectId &&
                Objects.equals(name, project.name) &&
                Objects.equals(budget, project.budget) &&
                Objects.equals(description, project.description) &&
                Objects.equals(managerId, project.managerId) &&
                Objects.equals(duration, project.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, name, budget, description, managerId, duration);
    }
}
