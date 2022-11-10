package com.TIComoApp.TIComo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.TIComoApp.TIComo.model.Valoracion;

@Repository
public interface ValoracionRepository extends MongoRepository<Valoracion,String>{
	
	

}
