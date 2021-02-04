package com.example.fsm.Model.Cost;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COST_TYPE")
public class CostType {
    private int costTypeId;
    private String name;


    @Id
    @GeneratedValue
    @Column(name = "COST_TYPE_ID")
    public int getCostTypeId() {
        return costTypeId;
    }

    public void setCostTypeId(int costTypeId) {
        this.costTypeId = costTypeId;
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
        CostType costType = (CostType) o;
        return costTypeId == costType.costTypeId &&
                Objects.equals(name, costType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(costTypeId, name);
    }
}
