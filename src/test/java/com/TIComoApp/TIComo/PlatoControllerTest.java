package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.TIComoApp.TIComo.controller.PlatoController;
import com.TIComoApp.TIComo.model.Plato;
import com.TIComoApp.TIComo.repository.PlatoRepository;

@SpringBootTest
public class PlatoControllerTest {
   @Autowired
   private PlatoRepository platoRepository;
   @Autowired
   private PlatoController platocontroller;
   
	@Test
	 void testC(){
	   platocontroller.delete("1A");
	   assertThrows(RuntimeException.class,() ->{platoRepository.findById("1A").orElseThrow(RuntimeException::new);});


	   }
   @Test
   void testA() {
	   Plato res=new Plato("1A","l","ok","Muy ricas",10.0,false,"LA casa");
       platocontroller.create(res);
       
      
      }
   @Test
	 void testB(){
	   Plato pla = new Plato("1A","lentejas","ok","Muy ricas",10.0,false,"LA casa");
	   Plato pla2 = platocontroller.update("1A", pla);
	   assertEquals(pla.toString(),pla2.toString());

	}

}