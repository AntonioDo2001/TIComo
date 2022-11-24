package com.TIComoApp.TIComo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TIComoApp.TIComo.controller.PedidoController;
import com.TIComoApp.TIComo.controller.RestauranteController;
import com.TIComoApp.TIComo.controller.RiderController;
import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.model.Pedido;
import com.TIComoApp.TIComo.model.Restaurante;
import com.TIComoApp.TIComo.model.Rider;
import com.TIComoApp.TIComo.repository.PedidoRepository;
import com.TIComoApp.TIComo.repository.RestauranteRepository;
import com.TIComoApp.TIComo.repository.RiderRepository;

@SpringBootTest
public class RiderControllerTest {
   @Autowired
   private RiderRepository riderRepository;
   @Autowired
   private RiderController ridercontroller;
   
  
   Rider res=new Rider("11111","Antonio","Tomás","aaa@gmail.com", "wazaasdasdasdasdasd1A", "62000000A", "Coche", "4444AAA", "Coche");
   Rider res2= new Rider("11112","Antonio","Tomás","bbb@gmail.com", "wazaasdasdasdasdasd1B", "62000000B", "Moto", "4444SAB", "Coche");
   Rider res3= new Rider("11113","Antonio","Tomás","www@gmail.com", "wazaasdasdasdasdasd1C", "62000000C", "Moto", "4444BBBB", "Coche");
   Rider res4= new Rider("11113","Antonio","Tomás","www@gmail", "wazaasdasdasdasdasd1C", "62000000D", "Moto", "4444BBB", "Coche");
   Rider res5= new Rider("11114","Antonio","Tomás","www@gmail", "waza", "62000000D", "Moto", "4444BBB", "Coche");
   
   @Rule
   public ExpectedException exception = ExpectedException.none();
  
   @Test
   void testCrearRider() {
       ridercontroller.create(res);
	   ridercontroller.create(res2);
	   ridercontroller.create(res3);
	   ridercontroller.create(res4);
	   ridercontroller.create(res5);
       
      
      }
   
	@Test
	 void testObtnerRider(){


		   ridercontroller.obtenerRider("11111");


	}
   
   
   
	@Test
	 void testActualizarRider(){


		   ridercontroller.update("11111",res2);

	       assertEquals(res2.getNIF(),ridercontroller.update("11111", res2).getNIF());
	       assertEquals("emailFormato",ridercontroller.update("11111", res4).getNIF());
	       assertEquals("errorMatricula",ridercontroller.update("11111", res3).getNIF());
	       assertEquals("errorPassword",ridercontroller.update("11111", res5).getNIF());


	}
	@Test
	void testDesactivarActivarRider() {
		Rider rid =ridercontroller.desactivarActivarRider(res);
		assertEquals(true,rid.isCuentaActiva());
	}
	
	
	@Test
	void testIndex() {
		List<Rider> list=ridercontroller.index();
		assertNotEquals(0,list.size());
	}
		
	@Test
	 void testEliminarRider(){
	   ridercontroller.delete("11112");
	   assertThrows(RuntimeException.class,() ->{riderRepository.findById("11112").orElseThrow(RuntimeException::new);});


	   }
		





}
