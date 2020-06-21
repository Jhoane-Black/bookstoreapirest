package com.yorch.springboot.apirest.models.VO;

import com.yorch.springboot.apirest.models.entity.Author;

import java.util.List;

public class BookVO {
    private long book_id;
    private String book_title;
    private String book_editorial;
    private String book_saga;
    private double book_price;
    private double book_price_dis;
    private List<Author> authors;

    public BookVO(long book_id, String book_title, String book_editorial, String book_saga, double book_price, double book_price_dis) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_editorial = book_editorial;
        this.book_saga = book_saga;
        this.book_price = book_price;
        this.book_price_dis = book_price_dis;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
