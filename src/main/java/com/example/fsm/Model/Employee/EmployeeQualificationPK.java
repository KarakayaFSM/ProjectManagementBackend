package com.example.fsm.Model.Employee;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EmployeeQualificationPK implements Serializable {
    private int employeeId;
    private int prereqId;

    @Column(name = "EMPLOYEE_ID")
    @Id
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "PREREQ_ID")
    @Id
    public int getPrereqId() {
        return prereqId;
    }

    public void setPrereqId(int prereqId) {
        this.prereqId = prereqId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeQualificationPK that = (EmployeeQualificationPK) o;
        return employeeId == that.employeeId &&
                prereqId == that.prereqId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, prereqId);
    }
}
