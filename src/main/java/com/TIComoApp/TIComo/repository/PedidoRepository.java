package com.TIComoApp.TIComo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.TIComoApp.TIComo.model.Pedido;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido,String>{
	
	

}