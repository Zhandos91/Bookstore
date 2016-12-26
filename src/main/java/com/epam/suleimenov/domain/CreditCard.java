package com.epam.suleimenov.domain;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

public class CreditCard {

    @NotBlank
    private String type;
    @NotBlank
    @CreditCardNumber
    private String number;
    @NotBlank
    @Pattern(regexp = "\\d{2}", message = "{validation.creditcard.month}")
    private String month;
    @NotBlank
    @Pattern(regexp = "\\d{4}", message = "{validation.creditcard.year}")
    private String year;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "CreditCard{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
