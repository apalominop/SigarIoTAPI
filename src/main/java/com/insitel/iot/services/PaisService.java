/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.Pais;
import com.insitel.iot.repositories.PaisRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */
@Service
public class PaisService {
	
	@Autowired
	PaisRepository paisRepository;
	
	/**
	 * Método para obtener todos los Paises
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pais> obtenerTodosPaises() throws Exception {
		return (ArrayList<Pais>) paisRepository.findAll();
	}

}
