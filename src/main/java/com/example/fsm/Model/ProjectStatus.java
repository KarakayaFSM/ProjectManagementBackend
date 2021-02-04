package com.example.fsm.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROJECT_STATUS")
public class ProjectStatus {
    private int statusCode;
    private String name;

    @Id
    @Column(name = "STATUS_CODE")
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectStatus that = (ProjectStatus) o;
        return statusCode == that.statusCode &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, name);
    }
}
