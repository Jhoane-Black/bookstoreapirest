package com.yorch.springboot.apirest.models.service;

import com.yorch.springboot.apirest.models.dao.IOrdenDao;
import com.yorch.springboot.apirest.models.entity.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdenServiceImpl implements IOrdenService {
    @Autowired
    private IOrdenDao iOrdenDao;

    @Override
    public Orden findById(long id) {
        return iOrdenDao.findById(id).orElse(null);
    }

    @Override
    public Orden save(Orden orden) {
        return iOrdenDao.save(orden);
    }

    @Override
    public void delete(Orden orden) {

    }

    @Override
    public List<Orden> findAll() {
        return (List<Orden>) iOrdenDao.findAll();
    }
}
