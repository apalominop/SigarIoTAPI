/**
 * 
 */
package com.insitel.iot.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insitel.iot.message.FileMessage;
import com.insitel.iot.models.InterfazArmario;
import com.insitel.iot.services.InterfazArmarioService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@RestController
@RequestMapping("/iot/ia")
public class InterfazArmarioController {

	@Autowired
	InterfazArmarioService interfazArmarioService;
	
	/**
	 * Servicio para obtener todas las IAs
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "obtenertodas", method = RequestMethod.GET)
	public ArrayList<InterfazArmario> obtenerIas() throws Exception {
		return interfazArmarioService.obtenerTodasIas();
	}
	
	/**
	 * Servicio para actualizar campos permitidos en la IA
	 * @param ia
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "actualizar", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> guardarIa(@RequestBody InterfazArmario ia) throws Exception {
		
		String message = "";
		Long id = ia.getId();
		String direccion = ia.getDireccion();
		double latitud = ia.getLatitud();
		double longitud = ia.getLongitud();
		String nombre = ia.getNombre();
		
		Optional<InterfazArmario> encontrada = interfazArmarioService.obtenerIaPorId(id);
		if (encontrada.isPresent()) {
			InterfazArmario aGrabar = encontrada.get();
			aGrabar.setDireccion(direccion);
			aGrabar.setLatitud(latitud);
			aGrabar.setLongitud(longitud);
			aGrabar.setNombre(nombre);
			
			interfazArmarioService.guardarIa(aGrabar);
			message = "Se actualizó la IA exitosamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar la IA";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}
	}
	
	/**
	 * Servicio para cambiar el estado de una IA
	 * @param ia
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "cambiarestado", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> cambiarEstadoIa(@RequestBody InterfazArmario ia) throws Exception {
		
		String message = "";
		Long id = ia.getId();
		
		Optional<InterfazArmario> encontrada = interfazArmarioService.obtenerIaPorId(id);
		if (encontrada.isPresent()) {
			InterfazArmario aGrabar = encontrada.get();
			aGrabar.setEstado(ia.getEstado());
			interfazArmarioService.guardarIa(aGrabar);
			message = "Se cambió el estado de la IA exitosamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar la IA";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}
	}
	
	
	@RequestMapping(value = "porid/{id}", method = RequestMethod.POST)
	public ResponseEntity<InterfazArmario> obtenerIaPorId(@PathVariable("id") Long id) throws Exception {
		Optional<InterfazArmario> ia = interfazArmarioService.obtenerIaPorId(id);
		if (ia.isPresent()) {
			return ResponseEntity.ok(ia.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
