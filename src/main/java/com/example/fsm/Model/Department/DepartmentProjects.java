package com.example.fsm.Model.Department;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DEPARTMENT_PROJECTS")
@IdClass(DepartmentProjectsPK.class)
public class DepartmentProjects {
    private int departmentId;
    private int projectId;

    @Id
    @Column(name = "DEPARTMENT_ID")
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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
        DepartmentProjects that = (DepartmentProjects) o;
        return departmentId == that.departmentId &&
                projectId == that.projectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, projectId);
    }
}
