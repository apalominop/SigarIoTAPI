/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.Grupo;
import com.insitel.iot.repositories.GrupoRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Service
public class GrupoService {
	
	@Autowired
	GrupoRepository grupoRepository;
	
	/**
	 * Método para obtener todos los grupos
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Grupo> obtenerGrupos() throws Exception {
		return (ArrayList<Grupo>) grupoRepository.findAll();
	}
	
	/**
	 * Método para guardar y actualizar un Grupo
	 * @param grupo
	 * @return
	 * @throws Exception
	 */
	public Grupo guardarGrupo(Grupo grupo) throws Exception {
		return grupoRepository.save(grupo);
	}
	
	/**
	 * Método para obtener un Grupo por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Optional<Grupo> obtenerGrupoPorId(Long id) throws Exception {
		return grupoRepository.findById(id);
	}

}
