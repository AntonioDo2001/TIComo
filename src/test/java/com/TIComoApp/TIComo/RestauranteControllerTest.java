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
   
   @Rule
   public ExpectedException exception = ExpectedException.none();
  
   
	Restaurante res= new Restaurante("1A","El molino","Comidas Manchegas S.L","A1B2C3D4", "Calle Desengaño 7", "656987125", "elmolinno@gmail.com", "Comida tradicional");
	Restaurante res4= new Restaurante("1T","Tomas","Tomás","Aquino Hayquienviva", "Calle Desengaño 26 3ºA", "600000008", "restaurant2@gmail.es", "Categoria ejemplo");
	Restaurante res2= new Restaurante("1B","Paco","Tomás","Aquino Hayquienviva", "Calle Desengaño 26 3ºA", "600000008", "restaurante", "Categoria ejemplo");
	Restaurante res3= new Restaurante("1C","Juan","Tomás","Aquino Hayquienviva", "Calle Desengaño 23 3ºA", "60000787887487847", "restaurante@prueba.com", "Categoria ejemplo");

	
   @Test
   void testCrearRestaurante() {
	   Restaurante res= new Restaurante("1A","El molino","Comidas Manchegas S.L","A1B2C3D4", "Calle Desengaño 7", "656987125", "elmolinno@gmail.com", "Comida tradicional");
		Restaurante res4= new Restaurante("1T","Tomas","Tomás","Aquino Hayquienviva", "Calle Desengaño 26 3ºA", "600000008", "restaurant2@gmail.es", "Categoria ejemplo");
		Restaurante res2= new Restaurante("1B","Paco","Tomás","Aquino Hayquienviva", "Calle Desengaño 26 3ºA", "600000008", "restaurante", "Categoria ejemplo");
		Restaurante res3= new Restaurante("1C","Juan","Tomás","Aquino Hayquienviva", "Calle Desengaño 23 3ºA", "60000787887487847", "restaurante@prueba.com", "Categoria ejemplo");

		assertNotEquals(null,restaurantecontroller.create(res));
		assertNotEquals(null,restaurantecontroller.create(res2));
		assertNotEquals(null,restaurantecontroller.create(res3));
      
      }
   
   @Test
   void testObtenerRestaurante() {

		restaurantecontroller.obtenerRestaurante("6362513747774a5c1af31a36");
      
      }
   
	@Test
	   void testActualizarRestaurante(){


	       assertEquals(res.getEmail(),restaurantecontroller.update("6362513747774a5c1af31a36", res).getEmail());
	       assertEquals("tlfFormErr",restaurantecontroller.update("6362513747774a5c1af31a36", res3).getEmail());

	      

	   }
	
	
	@Test
	void testIndex() {
		List<Restaurante> list=restaurantecontroller.index();
		assertNotEquals(0,list.size());
	}
		
		@Test
	   void testEliminarRestaurante(){
			
	       restaurantecontroller.delete("1A");

	       assertThrows(RuntimeException.class,() ->{restauranteRepository.findById("1A").orElseThrow(RuntimeException::new);});


	   }
		





}