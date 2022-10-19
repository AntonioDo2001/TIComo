package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Coche;

@Repository
public interface CocheRepository extends MongoRepository<Coche, String> {

}
