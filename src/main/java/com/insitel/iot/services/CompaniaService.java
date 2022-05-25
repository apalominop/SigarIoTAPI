/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.Compania;
import com.insitel.iot.repositories.CompaniaRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Service
public class CompaniaService {
	
	@Autowired
	CompaniaRepository companiaRepository;
	
	/**
	 * Método para obtener todas las Empresas
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Compania> obtenerTodasCompanias() throws Exception {
		return (ArrayList<Compania>) companiaRepository.findAll();
	}
	
	/**
	 * Método para guardar y actualizar una Compañia 
	 * @param compania
	 * @return
	 * @throws Exception
	 */
	public Compania guardarCompañia(Compania compania) throws Exception {
		return companiaRepository.save(compania);
	}
	
	/**
	 * Método para obtener Compañia por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Optional<Compania> obtenerCompaniaPorId(Long id) throws Exception {
		return companiaRepository.findById(id);
	}

}
