package com.TIComoApp.TIComo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TIComoApp.TIComo.model.Restaurante;

public interface RestauranteRepository extends MongoRepository<Restaurante,String>{

}