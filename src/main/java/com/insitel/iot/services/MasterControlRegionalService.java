/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.MasterControlRegional;
import com.insitel.iot.repositories.MasterControlRegionalRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Service
public class MasterControlRegionalService {
	
	@Autowired
	MasterControlRegionalRepository masterControlRegionalRepository;
	
	/**
	 * Método para obtener todos los MCR
	 * @return
	 * @throws Exception
	 */
	public ArrayList<MasterControlRegional> obtenerTodosMCR() throws Exception {
		return (ArrayList<MasterControlRegional>) masterControlRegionalRepository.findAll();
	}
	
	/**
	 * Método para guardar o actualizar un MCR
	 * @param mcr
	 * @return
	 * @throws Exception
	 */
	public MasterControlRegional guardarMCR(MasterControlRegional mcr) throws Exception {
		return masterControlRegionalRepository.save(mcr);
	}
	
	/**
	 * Método para buscar mcr por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Optional<MasterControlRegional> buscarMcrPorId(Long id) throws Exception {
		return masterControlRegionalRepository.findById(id);
	}

}
