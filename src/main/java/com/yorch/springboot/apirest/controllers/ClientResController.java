package com.yorch.springboot.apirest.controllers;

import com.yorch.springboot.apirest.util.GenericResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yorch.springboot.apirest.models.entity.*;

import com.yorch.springboot.apirest.models.service.*;

import java.util.List;

import static com.yorch.springboot.apirest.util.GenericResponseVO.ERROR;
import static com.yorch.springboot.apirest.util.GenericResponseVO.SUCCESS;


@CrossOrigin(origins =  "*" ,allowedHeaders="*")
@RestController
@RequestMapping("/client")
public class ClientResController {

	@Autowired
	private IClientService usuarioService;

	@GetMapping("/")
	public String wellcome() {
		System.out.println("wellcome test print out");
		return "Wllcome api test";
	}

	@PostMapping("/login")
	public GenericResponseVO validation(@RequestBody Client client) {
		Client u = usuarioService.findbyUP(client.getCli_email(), client.getCli_pass());
		if (u == null) {
			GenericResponseVO.status(401);
			return ERROR;
		}
		return SUCCESS;
	}
	
	@GetMapping("/login")
	public Respuesta getAll() {
		return usuarioService.findAll();
	}
	
	@GetMapping("/login/{id}")
	public Respuesta getById(@PathVariable int id) {
		return new Respuesta(200, "Usuario Encontrado", usuarioService.findById(id));
	}

	@PostMapping("/register")
	public Respuesta registerClient (@RequestBody Client client) {
		List<Client> clients = (List<Client>) usuarioService.findAll().getData();
		client.setCli_role(clients.size() < 1 ? ClientRole.admin : ClientRole.user);
		Client c = usuarioService.save(client);
		return c.getCli_id()!= 0 ? new Respuesta(201, "", c) : new Respuesta(401, "Client not saved", null);
	}
	
	@PutMapping("/update/{id}")
   	public @ResponseBody Respuesta updateClient (@RequestBody Client client, @PathVariable int id) {
        Client toEdit = usuarioService.findById(id);
        if (toEdit == null) {
            ERROR.setCodigo(400);
            return ERROR;
        }
//	@PutMapping("/login/{id}")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Respuesta update(@RequestBody Client client, @PathVariable int id) {
//		Client u = (Client)usuarioService.findById(id);
//		u.setUsuario(client.getUsuario()!=null ? client.getUsuario() : u.getUsuario());
//		u.setContrasena(client.getContrasena()!=null ? client.getContrasena() : u.getContrasena());
//		return new Respuesta(200, "usuario modificado", usuarioService.save(u));
//	}


}


