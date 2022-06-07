/**
 * 
 */
package com.insitel.iot.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insitel.iot.models.Referencia;
import com.insitel.iot.services.ReferenciaService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/iot/ref")
public class ReferenciaController {
	
	@Autowired
	ReferenciaService referenciaService;
	
	/**
	 * Servicio para obtener las referencias hijas de un padre
	 * @param cod
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "refporcod/{cod}", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Referencia>> obtenerHijos(@PathVariable("cod") String cod) throws Exception {
		ArrayList<Referencia> ref = referenciaService.obtenerHijos(cod);
		if (!ref.isEmpty()) {
			return ResponseEntity.ok(ref);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	/**
	 * Servicio para obtener todas las referencias
	 */
	@RequestMapping(value = "obtenertodas", method = RequestMethod.GET)
	public ArrayList<Referencia> obtenerTodasReferencias() throws Exception {
		return referenciaService.obtenerTodasReferencias();
	}
}
