package com.yorch.springboot.apirest.models.dao;

import com.yorch.springboot.apirest.models.entity.Genere;
import org.springframework.data.repository.CrudRepository;

public interface IGenereDao extends CrudRepository<Genere, Long> {
}
