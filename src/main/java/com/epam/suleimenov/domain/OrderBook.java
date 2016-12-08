package com.epam.suleimenov.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORDER_BOOK")
public class OrderBook extends BaseEntity implements Serializable {

    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private Order order;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    private Integer quantity;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
