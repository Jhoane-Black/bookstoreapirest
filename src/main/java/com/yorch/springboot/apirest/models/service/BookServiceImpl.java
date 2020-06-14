package com.yorch.springboot.apirest.models.service;

import com.yorch.springboot.apirest.models.dao.IBookDao;
import com.yorch.springboot.apirest.models.entity.Book;
import com.yorch.springboot.apirest.models.entity.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookDao iBookDao;

    @Override
    public Respuesta findAll() {
        return new Respuesta(200, "", iBookDao.findAll());
    }

    @Override
    public Book findById(int id) {
        return iBookDao.findById((long) id).orElse(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Book save(Book book) {
        return iBookDao.save(book);
    }
}
