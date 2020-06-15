package com.yorch.springboot.apirest.models.service;

import com.yorch.springboot.apirest.models.entity.Genere;

import java.util.List;

public interface IGenereService {

    public Genere findById(long id);

    public Genere save(Genere g);

    public void delete(Genere g);

    public List<Genere> findAll();
}
