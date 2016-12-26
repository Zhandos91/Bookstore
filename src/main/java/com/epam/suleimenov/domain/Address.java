package com.epam.suleimenov.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
public class Address extends BaseEntity implements Serializable {

    @Column(nullable = false)
    @NotBlank
    private String city;
    @Column(nullable = false)
    @NotBlank
    @Pattern(regexp = "\\w{2}", message = "{validation.state}")
    private String state;
    @Column(nullable = false)
    @NotBlank
    @Pattern(regexp = "\\d{6}", message = "{validation.zipcode}")
    private String zip_code;
    @Column(nullable = false)
    @NotBlank
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

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
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
