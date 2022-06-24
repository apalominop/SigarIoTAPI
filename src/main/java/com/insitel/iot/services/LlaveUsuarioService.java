/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.LlaveUsuario;
import com.insitel.iot.repositories.LlaveUsuarioRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */
@Service
public class LlaveUsuarioService {
	
	@Autowired
	LlaveUsuarioRepository llaveUsuarioRepository;
	
	/**
	 * Método para obtener todas las LlavesUsuario
	 * @return
	 * @throws Exception
	 */
	public ArrayList<LlaveUsuario> obtenerTodasLlavesUser() throws Exception {
		return (ArrayList<LlaveUsuario>) llaveUsuarioRepository.findAll();
	}
	
	/**
	 * Método para obtener las llaves asignadas a los usuarios
	 */
	public List<Object[]> obtenerLlavesPorUsuario() throws Exception {
		return llaveUsuarioRepository.obtenerLlavesPorUsuario();
	}

}
