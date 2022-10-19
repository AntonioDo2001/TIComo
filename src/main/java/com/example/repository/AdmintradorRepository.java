package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Administrador;

@Repository
public interface AdmintradorRepository extends MongoRepository<Administrador, String> {

}
