package com.yorch.springboot.apirest.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.yorch.springboot.apirest.models.entity.Client;

import java.util.List;

public interface IClientDao extends CrudRepository<Client, Integer>{
	
	@Query(value="SELECT c.* FROM client c WHERE c.cli_email =?1 and c.cli_pass = ?2",nativeQuery=true)
    Client findByUP(@Param("cli_email")String cli_email, @Param("cli_pass")String cli_pass);

}
