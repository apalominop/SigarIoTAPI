/**
 * 
 */
package com.insitel.iot.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insitel.iot.message.FileMessage;
import com.insitel.iot.models.User;
import com.insitel.iot.services.UserService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/iot/user")
public class UserBDController {
	
	@Autowired
	UserService userService;
	
	/**
	 * Servicio para obtener todos los User Login
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "obtenertodos", method = RequestMethod.GET)
	public ArrayList<User> obtenerTodosUsers() throws Exception {
		return userService.obtenerTodosUsers();
	}
	
	/**
	 * Servicio para guardar un User Login
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "guardar", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> guardarUser(@RequestBody User user) throws Exception {
		String message = "";
		userService.guardarUser(user);
		message = "Se guardó el User Login exitosamente";
		return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
	}
	
	/**
	 * Servicio para obtener un User Login por Id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "porid/{id}", method = RequestMethod.POST)
	public ResponseEntity<User> obtenerUserPorId(@PathVariable("id") Long id) throws Exception {
		Optional<User> user = userService.obtenerUserPorId(id);
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
