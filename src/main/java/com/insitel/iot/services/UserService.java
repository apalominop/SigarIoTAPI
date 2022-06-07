/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.User;
import com.insitel.iot.repositories.UserRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */
@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	/**
	 * Método para obtener todos los User Login
	 * @return
	 * @throws Exception
	 */
	public ArrayList<User> obtenerTodosUsers() throws Exception {
		return (ArrayList<User>) userRepository.findAll();
	}
	
	/**
	 * Método para guardar o actualizar un User Login
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User guardarUser(User user) throws Exception {
		return userRepository.save(user);
	}

	/**
	 * Método para obtener User Login por Id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Optional<User> obtenerUserPorId(Long id) throws Exception {
		return userRepository.findById(id);
	}
	
	/**
	 * Método para verificar User Login
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Optional<User> verificarUser(User user) throws Exception {
		return userRepository.verificarUser(user.getNombre(), user.getPassword());
	}
	
}
