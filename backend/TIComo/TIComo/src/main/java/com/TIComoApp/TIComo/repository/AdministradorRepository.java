package com.TIComoApp.TIComo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TIComoApp.TIComo.model.Administrador;

public interface AdministradorRepository extends MongoRepository<Administrador,String>{

}