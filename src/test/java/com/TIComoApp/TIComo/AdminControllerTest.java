package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TIComoApp.TIComo.controller.AdminController;
import com.TIComoApp.TIComo.controller.ClienteController;
import com.TIComoApp.TIComo.model.Administrador;
import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.repository.AdministradorRepository;
import com.TIComoApp.TIComo.repository.ClienteRepository;
@SpringBootTest
class AdminControllerTest {

	 @Autowired
	   private AdministradorRepository administradorRepository;
	   @Autowired
	   private AdminController admincontroller;
	   
	   Administrador res=new Administrador("1A","Antonio","Tomás","Toledo@gmail.com", "5555555555Aa", "620000000");
	   Administrador res2=  new Administrador("1B","Pepe","Tomása","Toledo2@gmail.com", "5555555555Aa", "620000000");
	   Administrador res3=  new Administrador("1C","Antonio","Tomásw","Toledo@gmail", "5555555555wAa", "620000000");
	   Administrador res4=  new Administrador("1F","Antonio","Tomás","Toledo@gmail.com", "55555", "620002000");

	   @Rule
	   public ExpectedException exception = ExpectedException.none();
	   @Test
	   void testCrearAdmin() {
		   Administrador res=new Administrador("1A","Antonio","Tomás","Toledo@gmail.com", "5555555555Aa", "620000000");
		   Administrador res2=  new Administrador("1B","Pepe","Tomása","Toledo2@gmail.com", "5555555555Aa", "620000000");
		   Administrador res3=  new Administrador("1C","Antonio","Tomásw","Toledo@gmail", "5555555555wAa", "620000000");
		   Administrador res4=  new Administrador("1F","Antonio","Tomás","Toledo@gmail.com", "55555", "620002000");

	       admincontroller.create(res);
	       admincontroller.create(res2);
	       admincontroller.create(res3);
	       admincontroller.create(res4);
	       
	      
	      }
	   
	   
	   @Test
	   void testObtenerAdmin(){

	       admincontroller.obtenerAdmin("1B");
	       
	      

	   }
	   
	   
		@Test
		   void testActualizarAdmin(){
			   Administrador res=new Administrador("1A","Antonio","Tomás","Toledo@gmail.com", "5555555555Aa", "620000000");
			   Administrador res2=  new Administrador("1B","Pepe","Tomása","Toledo2@gmail.com", "5555555555Aa", "620000000");
			   Administrador res3=  new Administrador("1C","Antonio","Tomásw","Toledo@gmail", "5555555555wAa", "620000000");
			   Administrador res4=  new Administrador("1F","Antonio","Tomás","Toledo@gmail.com", "55555", "620002000");

		       assertEquals("emailFormato",admincontroller.update("1B", res3).getEmail());
		       assertEquals("errorPassword",admincontroller.update("1B", res4).getEmail());
		       assertEquals(res2.getEmail(),admincontroller.update("1F", res2).getEmail());
		       



		   }
		@Test
		void testIndex() {
			List<Administrador> list=admincontroller.index();
			int size = list.size();
			assertEquals(size,list.size());
		}
		
			
			@Test
		   void testEliminarAdmin(){
				 admincontroller.delete("1A");

			       assertThrows(RuntimeException.class,() ->{administradorRepository.findById("1D").orElseThrow(RuntimeException::new);});

		   }
}
