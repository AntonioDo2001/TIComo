package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	

}