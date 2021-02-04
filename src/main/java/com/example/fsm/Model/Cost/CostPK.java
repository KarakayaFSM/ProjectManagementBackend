package com.example.fsm.Model.Cost;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CostPK implements Serializable {
    private int costId;
    private int taskId;

    @Column(name = "COST_ID")
    @Id
    public int getCostId() {
        return costId;
    }

    public void setCostId(int costId) {
        this.costId = costId;
    }

    @Column(name = "TASK_ID")
    @Id
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostPK costPK = (CostPK) o;
        return costId == costPK.costId &&
                taskId == costPK.taskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(costId, taskId);
    }
}
