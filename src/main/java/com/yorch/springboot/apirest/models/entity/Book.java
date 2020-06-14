package com.yorch.springboot.apirest.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long book_id;
    private String book_title;
    private String book_editorial;
    private String book_saga;
    private double book_price;
    private double book_price_dis;

    public Book() {
    }

    public long getBook_id() {
        return book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_editorial() {
        return book_editorial;
    }

    public void setBook_editorial(String book_editorial) {
        this.book_editorial = book_editorial;
    }

    public String getBook_saga() {
        return book_saga;
    }

    public void setBook_saga(String book_saga) {
        this.book_saga = book_saga;
    }

    public double getBook_price() {
        return book_price;
    }

    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }

    public double getBook_price_dis() {
        return book_price_dis;
    }

    public void setBook_price_dis(double book_price_dis) {
        this.book_price_dis = book_price_dis;
    }
}
