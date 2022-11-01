package com.TIComoApp.TIComo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.TIComoApp.TIComo.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente,String>{
	
	

}
