package com.TIComoApp.TIComo;

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
   
  
   Rider res=new Rider("1A","Antonio","Tomás","aaa@gmail.com", "waza", "620000000", "", "", "");

   @Rule
   public ExpectedException exception = ExpectedException.none();
  
   @Test
   void testCrearRider() {
	   res=new Rider("1A","Antonio","Tomás","Aquino Hayquienviva", "Calle Desengaño 21 3ºA", "600000000", "", "", "");
       ridercontroller.create(res);
       
      
      }
   
	@Test
	 void testActualizarRider(){
		   Rider res2= new Rider("1A2","Antonio","Tomás","bbb@gmail.com", "222222aB", "620000000", "", "4444AAAA", "");
		   Rider res3= new Rider("1A3","Antonio","Tomás","www@gmail", "222222aB", "620000000", "", "4444BBBB", "");
		   ridercontroller.update("1A2",res2);
	       ridercontroller.update("1A3",res3);

	       assertEquals(res2.toString(),ridercontroller.update("1A2", res2).toString());

	}
	
	@Test
	void testIndex() {
		List<Rider> list=ridercontroller.index();
		assertEquals(4,list.size());
	}
		
	@Test
	 void testEliminarRider(){
	   ridercontroller.delete("1A");
	   assertThrows(RuntimeException.class,() ->{riderRepository.findById("1A").orElseThrow(RuntimeException::new);});


	   }
		





}
