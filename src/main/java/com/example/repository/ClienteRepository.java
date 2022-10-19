package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
