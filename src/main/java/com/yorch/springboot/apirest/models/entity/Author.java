package com.yorch.springboot.apirest.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long aut_id;
    private String aut_name;

    @ManyToMany(mappedBy = "authors", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    public String getAut_name() {
        return aut_name;
    }

    public void setAut_name(String aut_name) {
        this.aut_name = aut_name;
    }

    public long getAut_id() {
        return aut_id;
    }

    public List<Book> getBooks() {
        return books;
    }
}
