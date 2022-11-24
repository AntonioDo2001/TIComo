package com.TIComoApp.TIComo;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.TIComoApp.TIComo.model.Pedido;
import com.TIComoApp.TIComo.model.Entrega;
import com.TIComoApp.TIComo.repository.PedidoRepository;
import com.TIComoApp.TIComo.controller.PedidoController;

@SpringBootTest
 public class PedidoControllerTest {
    @Autowired
    private PedidoRepository pedidorepository;
    @Autowired
    private PedidoController pedidocontroller;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    void testC() {
        pedidocontroller.delete("10");
        assertThrows(RuntimeException.class,() ->{pedidorepository.findById("10").orElseThrow(RuntimeException::new);});


    }
    
    @Test
    void testA() {
		Pedido pedido= new Pedido("10","Lentejas",10,2, "63624d6c47774a5c1af31a2f","");
        pedidocontroller.create(pedido);
        
       
       }

    @Test
    void testD() {
        List<Pedido> pedidosCliente=pedidocontroller.obtenerPedidos("63624d6c47774a5c1af31a2f");
        assertNotEquals(0,pedidosCliente.size());
       }
    @Test
    void testB() {
    	Entrega entrega = new Entrega("63754660a759c000999984b5","63624d6c47774a5c1af31a2f","","","","","",0.0,"");
    	Pedido pedido=pedidocontroller.pedidoRealizado("10", entrega);
    	assertEquals(true,pedido.isPedidoRealizado());
    	assertEquals(entrega.getId(),pedido.getIdEntrega());
    	
    }





}