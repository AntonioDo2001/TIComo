package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Rider;

@Repository
public interface RiderRepository extends MongoRepository<Rider, String> {

}
