package com.yorch.springboot.apirest.models.dao;

import com.yorch.springboot.apirest.models.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface IAuthorDao extends CrudRepository<Author, Long> {
}
