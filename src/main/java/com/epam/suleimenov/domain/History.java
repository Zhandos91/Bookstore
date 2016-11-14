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
    private Date date;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "History{" +
                "info='" + info + '\'' +
                ", date=" + date +
                '}';
    }
}
