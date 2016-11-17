package com.epam.suleimenov.domain;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
public class History extends BaseEntity implements Serializable{

    private String info;
    @Temporal(TemporalType.TIMESTAMP)
    private Date recorded_date;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getRecorded_date() {
        return recorded_date;
    }

    public void setRecorded_date(Date recorded_date) {
        this.recorded_date = recorded_date;
    }

    @Override
    public String toString() {
        return "History{" +
                "info='" + info + '\'' +
                ", date=" + recorded_date +
                '}';
    }
}
