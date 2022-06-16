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
import com.insitel.iot.models.Llave;
import com.insitel.iot.services.LlaveService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/iot/llave")
public class LlaveController {
	
	@Autowired
	LlaveService llaveService;
	
	/**
	 * Servicio para obtener todas las llaves
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "obtenertodas", method = RequestMethod.GET)
	public ArrayList<Llave> obtenerTodasLlaves() throws Exception {
		return (ArrayList<Llave>) llaveService.obtenerTodas();
	}
	
	/**
	 * Servicio para guardar y actualizar una llave
	 * @param llave
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "actualizar", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> guardarLlave(@RequestBody Llave llave) throws Exception {
		
		String message = "";
		Long id = llave.getId();
		
		Optional<Llave> encontrada = llaveService.obtenerLlavePorId(id);
		if (encontrada.isPresent()) {
			Llave aGrabar = encontrada.get();
			aGrabar.setComp(llave.getComp());
			aGrabar.setTipo(llave.getTipo());
			llaveService.guardarLlave(aGrabar);
			message = "Se actualizó la Llave exitosamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar Llave";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}
	}
	
	/**
	 * Servicio para cambiar el estado de una llave
	 * @param llave
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "cambiarest", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> cambiarEstadoLlave(@RequestBody Llave llave) throws Exception {
		
		String message = "";
		Long id = llave.getId();
		
		Optional<Llave> encontrada = llaveService.obtenerLlavePorId(id);
		if (encontrada.isPresent()) {
			Llave aGrabar = encontrada.get();
			aGrabar.setEst(llave.getEst());
			llaveService.guardarLlave(aGrabar);
			message = "Se cambió el estado de la Llave exitosamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar Llave";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}
	}
	
	/**
	 * Servicio para obtener una llave por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "porid/{id}", method = RequestMethod.POST)
	public ResponseEntity<Llave> obtenerLlavePorId(@PathVariable("id") Long id) throws Exception {
		Optional<Llave> llave = llaveService.obtenerLlavePorId(id);
		if (llave.isPresent()) {
			return ResponseEntity.ok(llave.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
