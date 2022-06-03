/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.GrupoUsuario;
import com.insitel.iot.repositories.GrupoUsuarioRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */
@Service
public class GrupoUsuarioService {
	
	@Autowired
	GrupoUsuarioRepository grupoUsuarioRepository;
	
	/**
	 * Método para obtener todos los GrupoUsuario
	 * @return
	 * @throws Exception
	 */
	public ArrayList<GrupoUsuario> obtenerTodosGruposUsrs() throws Exception {
		return (ArrayList<GrupoUsuario>) grupoUsuarioRepository.findAll();
	}

}
