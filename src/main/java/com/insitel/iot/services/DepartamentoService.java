/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.Departamento;
import com.insitel.iot.repositories.DepartamentoRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Service
public class DepartamentoService {
	
	@Autowired
	DepartamentoRepository departamentoRepository;
	
	/**
	 * Método para obtener todos los Departamentos
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Departamento> obtenerTodosDptos() throws Exception {
		return (ArrayList<Departamento>) departamentoRepository.findAll();
	}
	
	/**
	 * Método para guardar y actualizar un Departamento
	 * @param departamento
	 * @return
	 * @throws Exception
	 */
	public Departamento guardarDpto(Departamento departamento) throws Exception {
		return departamentoRepository.save(departamento);
	}
	
	/**
	 * Método para obtener un Departamento por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Optional<Departamento> obtenerDptoPorId(Long id) throws Exception {
		return departamentoRepository.findById(id);
	}

}
