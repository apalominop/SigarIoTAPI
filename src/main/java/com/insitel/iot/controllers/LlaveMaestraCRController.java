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

import com.insitel.iot.models.LlaveMaestraCR;
import com.insitel.iot.services.LlaveMaestraCRService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/iot/maestra")
public class LlaveMaestraCRController {
	
	@Autowired
	LlaveMaestraCRService llaveMaestraCRService;
	
	/**
	 * Servicio para obtener todas las Llaves Maestras del CR
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "obtenertodas", method = RequestMethod.GET)
	public ArrayList<LlaveMaestraCR> obtenerTodasMaestras() throws Exception {
		return llaveMaestraCRService.obtenerTodasMaestras();
	}

}
