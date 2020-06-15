package com.yorch.springboot.apirest.models.service;

import com.yorch.springboot.apirest.models.entity.Author;

import java.util.List;

public interface IAuthorService  {
    public Author findById(long id);

    public Author save(Author author);

    public void delete(Author author);

    public List<Author> findAll();
}
