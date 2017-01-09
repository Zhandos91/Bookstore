package com.epam.suleimenov.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Book.getAll", query = "select b from Book b where b.lang = :lang"),
        @NamedQuery(name = "Book.findById", query = "select b from Book b where b.id = :id and b.lang = :lang"),
})
public class Book extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    private String publisher;
    @Temporal(TemporalType.DATE)
    private Date released_date;
    @Column(nullable = false)
    private Double price;
    private Integer ISBN;
    private Integer pages;
    @Column(length = 2000)
    private String description;
    @Column
    private String lang;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Set<OrderBook> orderBooks = new HashSet<>();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getReleased_date() {
        return released_date;
    }

    public void setReleased_date(Date released_date) {
        this.released_date = released_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ",title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", released_date=" + released_date +
                ", price=" + price +
                ", ISBN=" + ISBN +
                ", pages=" + pages +
//                ", description='" + description + '\'' +
//                ", brief='" + brief + '\'' +
//                ", orders=" + orders +
                '}';
    }
}
