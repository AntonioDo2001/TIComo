/*********************************************************************
 *
 * Class Name: EntregaRepository
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase utiliza el repositorio de MongoDB para realizar las operaciones posibles de la clase entrega
 *
 **********************************************************************
 */
package com.TIComoApp.TIComo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.TIComoApp.TIComo.model.Entrega;

@Repository
public interface EntregaRepository extends MongoRepository<Entrega,String>{
	
	

}
