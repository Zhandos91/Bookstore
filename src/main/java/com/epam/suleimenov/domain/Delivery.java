package com.epam.suleimenov.domain;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Delivery extends BaseEntity implements Serializable {

    private String type;
    private String estimated_time;
    private Double cost;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEstimated_time() {
        return estimated_time;
    }

    public void setEstimated_time(String estimated_time) {
        this.estimated_time = estimated_time;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "type='" + type + '\'' +
                ", estimated_time='" + estimated_time + '\'' +
                ", cost=" + cost +
                '}';
    }
}
