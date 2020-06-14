package com.yorch.springboot.apirest.models.service;

import com.yorch.springboot.apirest.models.entity.Book;
import com.yorch.springboot.apirest.models.entity.Respuesta;

public interface IBookService {
    public Respuesta findAll();

    public Book findById(int id);

    public void delete(int id);

    public Book save (Book book);
}
