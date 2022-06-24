/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.Usuario;
import com.insitel.iot.repositories.UsuarioRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	/**
	 * Método para buscar todos los usuarios
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Usuario> obtenerTodosUsuarios() throws Exception {
		return (ArrayList<Usuario>) usuarioRepository.findAll();
	}
	
	/**
	 * Método para guardar o actualizar un usuario
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public Usuario guardarUsuario(Usuario usuario) throws Exception {
		return usuarioRepository.save(usuario);
	}
	
	/**
	 * Método para obteer Usuario por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Optional<Usuario> buscarUsuarioPorId(Long id) throws Exception {
		return usuarioRepository.findById(id);
	}
	
	/**
	 * Método para obtener todos los usuarios activos
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Usuario> obtenerUsersActivos() throws Exception {
		return (ArrayList<Usuario>) usuarioRepository.obtenerUsersActivos();
	}
	
}
