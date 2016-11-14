package com.epam.suleimenov.domain;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Address extends BaseEntity implements Serializable {

    private String city;
    private String state;
    private Integer zip_code;
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZip_code() {
        return zip_code;
    }

    public void setZip_code(Integer zip_code) {
        this.zip_code = zip_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip_code=" + zip_code +
                ", country='" + country + '\'' +
                '}';
    }
}
