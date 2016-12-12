package com.epam.suleimenov.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Customer.getAll", query = "select c from Customer c"),
        @NamedQuery(name = "Customer.fetchById", query = "select c from Customer c where c.id = :id"),
        @NamedQuery(name = "Customer.getByEmail", query = "select c from Customer c where c.email = :email")
})
public class Customer extends BaseEntity implements Serializable {

    @Column(nullable = false)
    @NotBlank
    private String first_name;
    @Column(nullable = false)
    @NotBlank
    private String last_name;
    @Column(nullable = false)
    @NotBlank
    @Pattern(regexp = "\\d{6}", message = "{phone.validation}")
    private String phone;
    @Column(nullable = false)
    @Email
    @NotBlank
    private String email;
    @Column(nullable = false)
    @NotBlank
    private String password;
    @Transient
    @NotBlank
    private String confirm_password;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE, CascadeType.MERGE})
    @JoinColumn(name = "customer_id", nullable = false)
    private List<Address> addresses;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "customer_id", nullable = false)
    private List<Order> orders;



    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {

        return "Customer{" +
                "id='" + id + '\'' +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
//                ", addresses=" + Arrays.asList(addresses) +
//                ", orders=" + Arrays.asList(orders) +
                '}';
    }
}
