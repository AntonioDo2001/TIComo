package com.TIComoApp.TIComo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TIComoApp.TIComo.model.Rider;

public interface RiderRepository extends MongoRepository<Rider,String>{

}