package com.TIComoApp.TIComo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.TIComoApp.TIComo.model.Entrega;

@Repository
public interface EntregaRepository extends MongoRepository<Entrega,String>{
	
	

}
