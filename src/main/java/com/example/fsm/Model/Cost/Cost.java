package com.example.fsm.Model.Cost;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(CostPK.class)
public class Cost {
    private int costId;
    private int taskId;
    private Integer cost;

    @Id
    @Column(name = "COST_ID")
    @GeneratedValue
    public int getCostId() {
        return costId;
    }

    public void setCostId(int costId) {
        this.costId = costId;
    }

    @Id
    @Column(name = "TASK_ID")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "COST")
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost1 = (Cost) o;
        return costId == cost1.costId &&
                taskId == cost1.taskId &&
                Objects.equals(cost, cost1.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(costId, taskId, cost);
    }
}
