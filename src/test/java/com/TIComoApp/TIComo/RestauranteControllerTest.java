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
import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.model.Pedido;
import com.TIComoApp.TIComo.model.Restaurante;
import com.TIComoApp.TIComo.model.Rider;
import com.TIComoApp.TIComo.repository.PedidoRepository;
import com.TIComoApp.TIComo.repository.RestauranteRepository;

@SpringBootTest
public class RestauranteControllerTest {
   @Autowired
   private RestauranteRepository restauranteRepository;
   @Autowired
   private RestauranteController restaurantecontroller;
   
   Restaurante res=new Restaurante("1A","Antonio","Tomás","Toledo", "Calle Desengaño 21 3ºA", "600000000", "h", "h");;

   @Rule
   public ExpectedException exception = ExpectedException.none();
  
   @Test
   void testCrearRestaurante() {
		res= new Restaurante("1A","Antonio","Tomás","Aquino Hayquienviva", "Calle Desengaño 21 3ºA", "600000000", "", "");
       restaurantecontroller.create(res);
       
      
      }
   
	@Test
	   void testActualizarRestaurante(){
	       restaurantecontroller.update("1A", res);
	       Restaurante res2= new Restaurante("1A","Antonio","Tomás","Toledo", "Calle Desengaño 21 3ºA", "600000000", "h", "h");
		   Restaurante res3= new Restaurante("1A","Antonio","Tomás","kkk@gmail.com", "Calle Desengaño 21 3ºAa", "620000000", "h", "h");
		   restaurantecontroller.update("1A",res2);
		   restaurantecontroller.update("1A",res3);

	       assertEquals(res2.toString(),restaurantecontroller.update("1A", res2).toString());

	      

	   }
	@Test
	void testIndex() {
		List<Restaurante> list=restaurantecontroller.index();
		assertEquals(4,list.size());
	}
		
		@Test
	   void testEliminarRestaurante(){
	       restaurantecontroller.delete("1A");

	       assertThrows(RuntimeException.class,() ->{restauranteRepository.findById("1A").orElseThrow(RuntimeException::new);});


	   }
		





}