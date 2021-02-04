package com.example.fsm.Model.Employee;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {
    private Integer employeeId;
    private Integer availability;
    private Integer workingHours;
    private Integer salary;
    private String name;
    private String lastName;
    private String email;

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "AVAILABILITY")
    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    @Basic
    @Column(name = "WORKING_HOURS")
    public Integer getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Integer workingHours) {
        this.workingHours = workingHours;
    }

    @Basic
    @Column(name = "SALARY")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
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
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId) &&
                Objects.equals(availability, employee.availability) &&
                Objects.equals(workingHours, employee.workingHours) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, availability, workingHours, salary, name, lastName);
    }
}
