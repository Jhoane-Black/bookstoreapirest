package com.yorch.springboot.apirest.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genere")
public class Genere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gen_id;
    private String gem_name;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "generes", fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    public String getGem_name() {
        return gem_name;
    }

    public void setGem_name(String gem_name) {
        this.gem_name = gem_name;
    }

    public long getGen_id() {
        return gen_id;
    }

    public List<Book> getBooks() {
        return books;
    }
}
