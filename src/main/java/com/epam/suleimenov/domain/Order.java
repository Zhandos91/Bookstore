package com.epam.suleimenov.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
public class Order extends BaseEntity implements Serializable {

    private String total_price;
    private Date ordered_date;
    private Integer tracking_num;
    private Integer quantities;
    private String payment_method;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expected_delivery;
    @ManyToMany
    @JoinTable(name = "ORDER_BOOK", joinColumns = @JoinColumn(name = "order_fk"), inverseJoinColumns = @JoinColumn(name = "book_fk"))
    private List<Book> books;
    @OneToOne
    private Delivery delivery;
    @OneToMany
    private List<Status> statuses;
    @OneToMany
    private List<History> histories;

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public Date getOrdered_date() {
        return ordered_date;
    }

    public void setOrdered_date(Date ordered_date) {
        this.ordered_date = ordered_date;
    }

    public Integer getTracking_num() {
        return tracking_num;
    }

    public void setTracking_num(Integer tracking_num) {
        this.tracking_num = tracking_num;
    }

    public Integer getQuantities() {
        return quantities;
    }

    public void setQuantities(Integer quantities) {
        this.quantities = quantities;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public Date getExpected_delivery() {
        return expected_delivery;
    }

    public void setExpected_delivery(Date expected_delivery) {
        this.expected_delivery = expected_delivery;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    @Override
    public String toString() {
        return "Order{" +
                "total_price='" + total_price + '\'' +
                ", ordered_date=" + ordered_date +
                ", tracking_num=" + tracking_num +
                ", quantities=" + quantities +
                ", payment_method='" + payment_method + '\'' +
                ", expected_delivery=" + expected_delivery +
                ", books=" + books +
                ", delivery=" + delivery +
                ", statuses=" + statuses +
                ", histories=" + histories +
                '}';
    }
}
