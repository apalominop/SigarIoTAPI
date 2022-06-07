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
import com.insitel.iot.models.Departamento;
import com.insitel.iot.services.DepartamentoService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/iot/dpto")
public class DepartamentoController {
	
	@Autowired
	DepartamentoService departamentoService;
	
	/**
	 * Servicio para obtener todos los Departamentos
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "obtenertodos", method = RequestMethod.GET)
	public ArrayList<Departamento> obtenerTodosDptos() throws Exception {
		return departamentoService.obtenerTodosDptos();
	}
	
	/**
	 * Servicio para guardar y actualizar un Departamento
	 * @param departamento
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "guardar", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> guardarDpto(@RequestBody Departamento departamento) throws Exception {
		String message = "";
		departamentoService.guardarDpto(departamento);
		message = "Se actualizó el Departamento exitosamente";
		return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
	}
	
	/**
	 * Servicio para obtener un Departamento por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "porid/{id}", method = RequestMethod.POST)
	public ResponseEntity<Departamento> obtenerDptoPorId(@PathVariable("id") Long id) throws Exception {
		Optional<Departamento> dpto = departamentoService.obtenerDptoPorId(id);
		if (dpto.isPresent()) {
			return ResponseEntity.ok(dpto.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
