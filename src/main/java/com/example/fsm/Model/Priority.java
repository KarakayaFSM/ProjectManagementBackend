package com.example.fsm.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Priority {
    private int priorityId;
    private Long priorityLevel;

    @Id
    @Column(name = "PRIORITY_ID")
    @GeneratedValue
    public int getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    @Basic
    @Column(name = "PRIORITY_LEVEL")
    public Long getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Long priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Priority priority = (Priority) o;
        return priorityId == priority.priorityId &&
                Objects.equals(priorityLevel, priority.priorityLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priorityId, priorityLevel);
    }
}
