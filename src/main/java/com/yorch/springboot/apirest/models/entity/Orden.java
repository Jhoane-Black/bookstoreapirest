package com.yorch.springboot.apirest.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orden")
public class Orden implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "ord_book_id", referencedColumnName = "book_id")
    private Book book;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "ord_cli_id", referencedColumnName = "cli_id")
    private Client client;

    private Date ord_date;

    private double ord_price;

    private Date ord_pay_day;

    @Enumerated(EnumType.STRING)
    private OrdenStatus status;

    public Orden() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getOrd_date() {
        return ord_date;
    }

    public void setOrd_date(Date ord_date) {
        this.ord_date = ord_date;
    }

    public double getOrd_price() {
        return ord_price;
    }

    public void setOrd_price(double ord_price) {
        this.ord_price = ord_price;
    }

    public Date getOrd_pay_day() {
        return ord_pay_day;
    }

    public void setOrd_pay_day(Date ord_pay_day) {
        this.ord_pay_day = ord_pay_day;
    }

    public OrdenStatus getStatus() {
        return status;
    }

    public void setStatus(OrdenStatus status) {
        this.status = status;
    }
}
