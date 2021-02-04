package com.example.fsm.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Resources {
    private int resourceId;
    private Integer cost;
    private String name;
    private Boolean availability;

    @Id
    @Column(name = "RESOURCE_ID")
    @GeneratedValue
    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Basic
    @Column(name = "COST")
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
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
    @Column(name = "AVAILABILITY")
    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resources resources = (Resources) o;
        return resourceId == resources.resourceId &&
                Objects.equals(cost, resources.cost) &&
                Objects.equals(name, resources.name) &&
                Objects.equals(availability, resources.availability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceId, cost, name, availability);
    }
}
