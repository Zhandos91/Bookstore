package com.epam.suleimenov.domain;


import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Status extends BaseEntity implements Serializable {

    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Status{" +
                "info='" + info + '\'' +
                '}';
    }
}
