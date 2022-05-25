/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.Armario;
import com.insitel.iot.repositories.ArmarioRepository;


/**
 * @author Agustín Palomino Pardo
 *
 */

@Service
public class ArmarioService {
	
	@Autowired
	ArmarioRepository armarioRepository;
	
	/**
	 * Método para buscar todos los armarios
	 * @return
	 */
	public ArrayList<Armario> obtenerArmarios() throws Exception {
		return (ArrayList<Armario>) armarioRepository.findAll();
	}
	
	/**
	 * Método para guardar y actualizar armario
	 * @param armario
	 * @return
	 * @throws Exception
	 */
	public Armario guardarArmario(Armario armario) throws Exception {
		return armarioRepository.save(armario);
	}
	
	/**
	 * Método para obtener armario por Id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Optional<Armario> obtenerArmarioPorId(Long id) throws Exception {
		return armarioRepository.findById(id);
	}

}
