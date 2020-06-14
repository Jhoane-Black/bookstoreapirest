package com.yorch.springboot.apirest.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yorch.springboot.apirest.models.dao.*;

import com.yorch.springboot.apirest.models.entity.*;

@Service
public class ClientServiceImpl implements IClientService {
	@Autowired
	private IClientDao usuarioDao;

	@Override
	@Transactional(readOnly=true)
	public Respuesta findAll() {
		// TODO Auto-generated method stub
		return new Respuesta(200, "Usuarios todos", usuarioDao.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public Client findById(int id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Client save(Client client) {
		// TODO Auto-generated method stub
		return usuarioDao.save(client);
	}

	@Override
	public Client findbyUP(String cli_email, String cli_pass) {
		// TODO Auto-generated method stub
		return usuarioDao.findByUP(cli_email, cli_pass);
	}

}
