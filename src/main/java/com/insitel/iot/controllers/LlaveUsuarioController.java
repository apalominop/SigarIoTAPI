/**
 * 
 */
package com.insitel.iot.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insitel.iot.models.LlaveUsuario;
import com.insitel.iot.services.LlaveUsuarioService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/iot/llaveusr")
public class LlaveUsuarioController {
	
	@Autowired
	public LlaveUsuarioService llaveUsuarioService;
	
	/**
	 * Servicio para obtener todas las LlaveUsuario
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "obtenertodas", method = RequestMethod.GET)
	public ArrayList<LlaveUsuario> obtenerTodasLlavesUser() throws Exception {
		return llaveUsuarioService.obtenerTodasLlavesUser();
	}

}
