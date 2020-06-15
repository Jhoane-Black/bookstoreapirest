package com.yorch.springboot.apirest.models.service;

import com.yorch.springboot.apirest.models.entity.Orden;

import java.util.List;

public interface IOrdenService {

    public Orden findById(long id);

    public Orden save(Orden orden);

    public void delete(Orden orden);

    public List<Orden> findAll();
}
