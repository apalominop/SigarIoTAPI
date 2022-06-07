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
import com.insitel.iot.models.MasterControlRegional;
import com.insitel.iot.services.MasterControlRegionalService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/iot/mcr")
public class MasterControlRegionalController {
	
	@Autowired
	MasterControlRegionalService masterControlRegionalService;
	
	/**
	 * Servicio para obtener todos los CRMs
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "obtenertodos", method = RequestMethod.GET)
	public ArrayList<MasterControlRegional> obtenerTodosCmr() throws Exception {
		return masterControlRegionalService.obtenerTodosMCR();
	}
	
	/**
	 * Servicio para guardar y actualizar campos del MCR
	 * @param mcr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "actualizar", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> guardarCrm(@RequestBody MasterControlRegional mcr) throws Exception {
		
		String message = "";
		Long id = mcr.getId();
		String direccion = mcr.getDireccion();
		String nombre = mcr.getNombre();
		double latitud = mcr.getLatitud();
		double longitud = mcr.getLongitud();
		
		Optional<MasterControlRegional> encontrado = masterControlRegionalService.buscarMcrPorId(id);
		if (encontrado.isPresent()) {
			MasterControlRegional aGrabar = encontrado.get();
			aGrabar.setDireccion(direccion);
			aGrabar.setNombre(nombre);
			aGrabar.setLatitud(latitud);
			aGrabar.setLongitud(longitud);
			
			masterControlRegionalService.guardarMCR(aGrabar);
			message = "Se actualizó el CR exitosamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar CR";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}
	}
	
	/**
	 * Servicio para cambiar el estado del MCR
	 * @param mcr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "cambiarest", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> cambiarEstadoMcr(@RequestBody MasterControlRegional mcr) throws Exception {
		
		String message = "";
		Long id = mcr.getId();
		
		Optional<MasterControlRegional> encontrado = masterControlRegionalService.buscarMcrPorId(id);
		if (encontrado.isPresent()) {
			MasterControlRegional aGrabar = encontrado.get();
			aGrabar.setEstado(mcr.getEstado());
			
			masterControlRegionalService.guardarMCR(aGrabar);
			message = "Se cambió el estado del CR exitosamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar CR";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}
	}
	
	/**
	 * Servicio para obtener mcr por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "porid/{id}", method = RequestMethod.POST)
	public ResponseEntity<MasterControlRegional> obtenerMcrPorId(@PathVariable("id") Long id) throws Exception {
		Optional<MasterControlRegional> mcr = masterControlRegionalService.buscarMcrPorId(id);
		if (mcr.isPresent()) {
			return ResponseEntity.ok(mcr.get());		
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
