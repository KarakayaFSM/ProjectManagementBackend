package com.example.fsm.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Prereq {
    private int prereqId;
    private String prereqDefinition;

    @Id
    @Column(name = "PREREQ_ID")
    @GeneratedValue
    public int getPrereqId() {
        return prereqId;
    }

    public void setPrereqId(int prereqId) {
        this.prereqId = prereqId;
    }

    @Basic
    @Column(name = "PREREQ_DEFINITION")
    public String getPrereqDefinition() {
        return prereqDefinition;
    }

    public void setPrereqDefinition(String prereqDefinition) {
        this.prereqDefinition = prereqDefinition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prereq prereq = (Prereq) o;
        return prereqId == prereq.prereqId &&
                Objects.equals(prereqDefinition, prereq.prereqDefinition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prereqId, prereqDefinition);
    }
}
