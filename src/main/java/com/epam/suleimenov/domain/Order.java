package com.epam.suleimenov.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BOOK_ORDER")
@NamedQueries({
        @NamedQuery(name = "Order.getAll", query = "select o from Order o where o.lang = :lang"),
        @NamedQuery(name = "Order.findById", query = "select o from Order o where o.id = :id and o.lang = :lang"),
})
public class Order extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private Double total_price;
    @Column(nullable = false)
    private Date ordered_date;
    @Column(nullable = false)
    private Integer tracking_num;
    @Column(nullable = false)
    private Integer quantities;
    @Column(nullable = false)
    private String payment_method;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expected_delivery;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<OrderBook> orderBooks = new HashSet<>();

    @Column
    private String lang;

    @OneToOne
    @Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
    @JoinColumn
    private Delivery delivery;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "order_id")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Status> statuses;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "order_id")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<History> histories;

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
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

    public Set<OrderBook> getOrderBooks() {
        return orderBooks;
    }

    public void setOrderBooks(Set<OrderBook> orderBooks) {
        this.orderBooks = orderBooks;
    }

    public void addOrderBook(OrderBook orderBook) {
        this.orderBooks.add(orderBook);
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

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                "total_price='" + total_price + '\'' +
                ", ordered_date=" + ordered_date +
                ", tracking_num=" + tracking_num +
                ", quantities=" + quantities +
                ", payment_method='" + payment_method + '\'' +
                ", expected_delivery=" + expected_delivery +
//                ", books=" + books +
//                ", delivery=" + delivery +
//                ", statuses=" + statuses +
//                ", histories=" + histories +
                '}';
    }
}
