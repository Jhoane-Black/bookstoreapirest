package com.yorch.springboot.apirest.models.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

    @Cascade({org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.REFRESH})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "genere_has_book",
            joinColumns = @JoinColumn(name = "gxb_book_id"),
            inverseJoinColumns = @JoinColumn(name = "gxb_gen_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"gxb_book_id", "gxb_gen_id"})}
    )
    private Set<Genere> generes = new HashSet();

    @Cascade({org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.REFRESH})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_has_author",
            joinColumns = @JoinColumn(name = "book_book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_aut_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"book_book_id", "author_aut_id"})}
    )
    private Set<Author> authors = new HashSet<>();


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

    public Set<Genere> getGeneres() {
        return generes;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
}
