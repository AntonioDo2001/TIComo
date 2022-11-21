package com.TIComoApp.TIComo;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.TIComoApp.TIComo.model.Entrega;
import com.TIComoApp.TIComo.model.Pedido;
import com.TIComoApp.TIComo.repository.EntregaRepository;
import com.TIComoApp.TIComo.controller.EntregaController;

@SpringBootTest
 public class EntregaControllerTest {
	@Autowired
	private EntregaRepository entregaRepository;
	@Autowired
	private EntregaController entregacontroller;
	 
	Pedido ped;
	@Test
	void testMarcarEntregado() {
		Entrega ent= new Entrega("","63624d6c47774a5c1af31a2f","Tomás","Aquino Hayquienviva", "Calle Desengaño 21 3ºA", "600000000","",0.0,"Paca");
		Entrega ent2 = entregacontroller.marcarEntregado(ent);

		assertEquals(true,ent2.isEntregado());
		assertEquals("",ent.getIdRider());
		assertEquals("entregado",ent.getEstado());
	}
	
	 
	@Test
	void testIndex() {
		List<Entrega> entregaCliente=entregacontroller.obtenerEntregasCliente("63624d6c47774a5c1af31a2f");
        assertEquals(entregaCliente.size(),7);
	}
	@Test
    void testListarEntrega() {
        List<Entrega> entregaCliente=entregacontroller.obtenerEntregasCliente("63624d6c47774a5c1af31a2f");
        assertEquals(entregaCliente.size(),7);
       }
	
	@Test
    void crearEntrega() {
		Entrega ent= new Entrega("","63624d6c47774a5c1af31a2f","Tomás","Aquino Hayquienviva", "Calle Desengaño 21 3ºA", "600000000","",0.0,"Paca");
        entregacontroller.create(ent);
        
       
       }
	
	@Test
    void testEliminarEntrega(){
        entregacontroller.delete("637559490a1fd801b36465e2");

        assertThrows(RuntimeException.class,() ->{entregaRepository.findById("637559490a1fd801b36465e2").orElseThrow(RuntimeException::new);});
    }
	
	@Test
    void testAsignarRider(){
        entregacontroller.asignarRider("","63624c4747774a5c1af31a2d");

        assertTrue(entregaRepository.findById("").get().getIdRider().equals("63624c4747774a5c1af31a2d"));


    }
	
	
	
}
