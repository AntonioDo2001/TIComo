package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Plato;

@Repository
public interface PlatoRepository extends MongoRepository<Plato, String> {

}
