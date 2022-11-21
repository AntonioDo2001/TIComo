package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TIComoApp.TIComo.controller.ClienteController;
import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.repository.ClienteRepository;
@SpringBootTest
class ClienteControllerTest {

	 @Autowired
	   private ClienteRepository clienteRepository;
	   @Autowired
	   private ClienteController clientecontroller;
	   
	   Cliente res=new Cliente("1A","Antonio","Tomás","Toledo@gmail.com", "5555555555Aa", "620000000", "", "666666333");

	   @Rule
	   public ExpectedException exception = ExpectedException.none();
	   @Test
	   void testCrearCliente() {
		   Cliente res= new Cliente("1A","Antonio","Tomás","Toledo@gmail.com", "Calle Desengaño 21 3ºA", "620000000", "", "");
		   Cliente res2= new Cliente("1A","Antonio","Tomás","Toledo@gmail.com", "Calle Desengaño 21 3ºA", "620000000", "", "");
		   Cliente res3= new Cliente("1A","Antonio","Tomás","Toledo", "Calle Desengaño 21 3ºA", "620000000", "", "");
		   Cliente res4= new Cliente("1A","Antonio","Tomás","Toledo@gmail.com", "Calle Desengaño 21 3ºA", "620000000", "", "555444333");
	       clientecontroller.create(res);
	       clientecontroller.create(res2);
	       clientecontroller.create(res3);
	       clientecontroller.create(res4);
	       
	      
	      }
	   
		@Test
		   void testActualizarCliente(){
			   Cliente res2= new Cliente("1A","Antonio","Tomás","Toledo", "Calle Desengaño 21 3ºAa", "620000000", "", "");
			   Cliente res3= new Cliente("1A","Antonio","Tomás","kkk@gmail.com", "Calle Desengaño 21 3ºAa", "620000000", "", "");
			   clientecontroller.update("10",res2);
		       clientecontroller.update("10",res3);

		       assertEquals(res2.toString(),clientecontroller.update("1A", res2).toString());
		       



		   }
		@Test
		void testIndex() {
			List<Cliente> list=clientecontroller.index();
			assertEquals(6,list.size());
		}
		
			
			@Test
		   void testEliminarCliente(){
		       clientecontroller.delete("1A");

		       assertThrows(RuntimeException.class,() ->{clienteRepository.findById("10").orElseThrow(RuntimeException::new);});


		   }
}