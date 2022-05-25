/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.InterfazArmario;
import com.insitel.iot.repositories.InterfazArmarioRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Service
public class InterfazArmarioService {
	
	@Autowired
	InterfazArmarioRepository interfazArmarioRepository;
	
	/**
	 * Método para obtener todas las IAs
	 * @return
	 * @throws Exception
	 */
	public ArrayList<InterfazArmario> obtenerTodasIas() throws Exception {
		return (ArrayList<InterfazArmario>) interfazArmarioRepository.findAll();
	}
	
	/**
	 * Método para guardar o actualizar una IA
	 * @param ia
	 * @return
	 * @throws Exception
	 */
	public InterfazArmario guardarIa(InterfazArmario ia) throws Exception {
		return interfazArmarioRepository.save(ia);
	}
	
	public Optional<InterfazArmario> obtenerIaPorId(Long id) throws Exception {
		return interfazArmarioRepository.findById(id);
	}

}
