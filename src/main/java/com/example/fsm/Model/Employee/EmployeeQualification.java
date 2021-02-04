package com.example.fsm.Model.Employee;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE_QUALIFICATION")
@IdClass(EmployeeQualificationPK.class)
public class EmployeeQualification {
    private int employeeId;
    private int prereqId;

    @Id
    @Column(name = "EMPLOYEE_ID")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Id
    @Column(name = "PREREQ_ID")
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
        EmployeeQualification that = (EmployeeQualification) o;
        return employeeId == that.employeeId &&
                prereqId == that.prereqId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, prereqId);
    }
}
