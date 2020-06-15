package com.yorch.springboot.apirest.models.service;

import com.yorch.springboot.apirest.models.dao.IGenereDao;
import com.yorch.springboot.apirest.models.entity.Genere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenereServiceImpl implements IGenereService {
    @Autowired
    private IGenereDao iGenereDao;

    @Override
    public Genere findById(long id) {
        return iGenereDao.findById(id).orElse(null);
    }

    @Override
    public Genere save(Genere g) {
        return iGenereDao.save(g);
    }

    @Override
    public void delete(Genere g) {

    }

    @Override
    public List<Genere> findAll() {
        List<Genere> response = new ArrayList<>();
        iGenereDao.findAll().forEach(response::add);
        return response;
    }
}
