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
	 
	
	@Test
	void testMarcarEntregado() {
		Entrega ent= new Entrega("1234A5w4d5w7d4r5e","63624d6c47774a5c1af31a2f","Tomás","Aquino Hayquienviva", "Calle Desengaño 21 3ºA", "600000000","",0.0,"Paca");
		entregacontroller.create(ent);
		Entrega ent2 = entregacontroller.marcarEntregado(ent);
		entregacontroller.create(ent2);
		ent.setId("532");
		ent.setIdRider("");
		ent.setEntregado(true);
		assertEquals(true,ent.isEntregado());
		assertEquals("",ent.getIdRider());
		if(ent.isEntregado()) 
			ent.setEstado("entregado");
		assertEquals("entregado",ent.getEstado());
	}
	
	 
	@Test
	void testIndex() {
		List<Entrega> entregaCliente=entregacontroller.obtenerEntregasCliente("63624d6c47774a5c1af31a2f");
        assertNotEquals(entregaCliente.size(),0);
	}
	@Test
    void testListarEntrega() {
        List<Entrega> entregaCliente=entregacontroller.obtenerEntregasCliente("63624d6c47774a5c1af31a2f");
        assertNotEquals(entregaCliente.size(),0);
       }
	
	@Test
    void crearEntrega() {
		Entrega ent= new Entrega("454544adf5445asf","63624d6c47774a5c1af31a2f","Tomás","Aquino Hayquienviva", "Calle Desengaño 21 3ºA", "600000000","",0.0,"Paca");
        entregacontroller.create(ent);
        
       
       }
	
	@Test
    void testEliminarEntrega(){
        entregacontroller.delete("454544adf5445asf");
        assertThrows(RuntimeException.class,() ->{entregaRepository.findById("637559490a1fd801b36465e2").orElseThrow(RuntimeException::new);});
    }
	
	@Test
    void testAsignarRider(){
		Entrega ent= new Entrega("45dsd45dasd54SDsa","63624d6c47774a5c1af31a2f","Tomás","Aquino Hayquienviva", "Calle Desengaño 21 3ºA", "600000000","",0.0,"Paca");
		entregacontroller.create(ent);
        entregacontroller.asignarRider("","637bacee3fbad38b2861b937");

        assertTrue(entregaRepository.findById("").get().getIdRider().equals("637bacee3fbad38b2861b937"));


    }
	
	
	
}
