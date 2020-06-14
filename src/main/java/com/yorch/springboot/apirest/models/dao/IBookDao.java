package com.yorch.springboot.apirest.models.dao;

import com.yorch.springboot.apirest.models.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface IBookDao extends CrudRepository<Book, Long> {
}
