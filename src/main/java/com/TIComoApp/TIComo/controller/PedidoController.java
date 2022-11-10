
package com.TIComoApp.TIComo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.TIComoApp.TIComo.model.Pedido;
import com.TIComoApp.TIComo.repository.PedidoRepository;

@CrossOrigin
@RestController
@RequestMapping("ticomo/pedidos")



public class PedidoController {	
	@Autowired
	private PedidoRepository pedidoRepository;
		
	
	
	
	@GetMapping("")
	List<Pedido> index(){
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	List<Pedido> obtenerPedidos(@PathVariable String id) {
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<Pedido> pedidosCliente = new ArrayList<Pedido>();		
		for(int i=0;i<pedidos.size();i++) {
			if(pedidos.get(i).getId() == id) {
				pedidosCliente.add(pedidos.get(i));
			}
		}
		return pedidosCliente;
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	Pedido create(@RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	void delete(@PathVariable String id) {
		Pedido pedido = pedidoRepository.findById(id).orElseThrow(RuntimeException::new);
		pedidoRepository.delete(pedido);

	}
	

}