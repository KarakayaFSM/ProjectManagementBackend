package com.example.fsm.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Consumable {
    private int consumableId;
    private Integer unitCost;
    private String name;

    @Id
    @Column(name = "CONSUMABLE_ID")
    @GeneratedValue
    public int getConsumableId() {
        return consumableId;
    }

    public void setConsumableId(int consumableId) {
        this.consumableId = consumableId;
    }

    @Basic
    @Column(name = "UNIT_COST")
    public Integer getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Integer unitCost) {
        this.unitCost = unitCost;
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
        Consumable that = (Consumable) o;
        return consumableId == that.consumableId &&
                Objects.equals(unitCost, that.unitCost) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consumableId, unitCost, name);
    }
}
