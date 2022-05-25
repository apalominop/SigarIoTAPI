/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.Llave;
import com.insitel.iot.repositories.LlaveRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Service
public class LlaveService {
	
	@Autowired
	LlaveRepository llaveRepository;
	
	/**
	 * Método para obtener todas la llaves
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Llave> obtenerTodas() throws Exception {
		return (ArrayList<Llave>) llaveRepository.findAll();
	}
	
	/**
	 * Método para guardar y actualizar una llave
	 * @param llave
	 * @return
	 * @throws Exception
	 */
	public Llave guardarLlave(Llave llave) throws Exception {
		return llaveRepository.save(llave);
	}
	
	/**
	 * Método para obtener una llave por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Optional<Llave> obtenerLlavePorId(Long id) throws Exception {
		return llaveRepository.findById(id);
	}

}
