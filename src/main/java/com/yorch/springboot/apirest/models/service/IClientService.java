package com.yorch.springboot.apirest.models.service;

import com.yorch.springboot.apirest.models.entity.Client;
import com.yorch.springboot.apirest.models.entity.Respuesta;

public interface IClientService {
public Respuesta findAll();
	
	public Client findById(int id);
	
	public void delete(int id);
	
	public Client save (Client client);
	
	public Client findbyUP(String cli_email, String cli_pass);
}
