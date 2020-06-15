package com.yorch.springboot.apirest.models.service;

import com.yorch.springboot.apirest.models.dao.IAuthorDao;
import com.yorch.springboot.apirest.models.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {
    @Autowired
    private IAuthorDao iAuthorDao;

    @Override
    public Author findById(long id) {
        return iAuthorDao.findById(id).orElse(null);
    }

    @Override
    public Author save(Author author) {
        return iAuthorDao.save(author);
    }

    @Override
    public void delete(Author author) {
    }

    @Override
    public List<Author> findAll() {
        return (List<Author>) iAuthorDao.findAll();
    }
}
