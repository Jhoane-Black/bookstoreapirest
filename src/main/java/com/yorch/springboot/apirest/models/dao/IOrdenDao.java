package com.yorch.springboot.apirest.models.dao;

import com.yorch.springboot.apirest.models.entity.Orden;
import org.springframework.data.repository.CrudRepository;

public interface IOrdenDao extends CrudRepository<Orden, Long> {
}
