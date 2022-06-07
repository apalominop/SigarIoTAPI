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
import com.insitel.iot.models.Armario;
import com.insitel.iot.services.ArmarioService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/iot/armario")
public class ArmarioController {

	@Autowired
	ArmarioService armarioService;

	/**
	 * Servicio para obtener todos los armarios
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "obtenertodos", method = RequestMethod.GET)
	public ArrayList<Armario> obtenerArmarios() throws Exception {
		return armarioService.obtenerArmarios();
	}

	/**
	 * Servicio para modificar campos de Armario
	 * 
	 * @param armario
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "actualizar", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> guardarArmario(@RequestBody Armario armario) throws Exception {
		
		String message = "";
		Long id = armario.getId();
		String direccion = armario.getDireccion();
		String distrito = armario.getDistrito();
		Double latitud = armario.getLatitud();
		Double longitud = armario.getLongitud();
		
		Optional<Armario> encontrado = armarioService.obtenerArmarioPorId(id);
		if (encontrado.isPresent()) {
			Armario aGrabar = encontrado.get();
			aGrabar.setDireccion(direccion);
			aGrabar.setDistrito(distrito);
			aGrabar.setLatitud(latitud);
			aGrabar.setLongitud(longitud);
			
			armarioService.guardarArmario(aGrabar);
			message = "Se ha actualizado el Armario correctamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar Armario";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}

	}

	/**
	 * Servicio para modificar el estado del Armario
	 * @param armario
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "cambiarest", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> cambiarEstadoArmario(@RequestBody Armario armario) throws Exception {
		
		String message = "";
		Long id = armario.getId();

		Optional<Armario> encontrado = armarioService.obtenerArmarioPorId(id);
		if (encontrado.isPresent()) {
			Armario aGrabar = encontrado.get();
			aGrabar.setEstado(armario.getEstado());
			
			armarioService.guardarArmario(aGrabar);
			message = "Se cambió el estado del Armario correctamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar Armario";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}
		
	}

	/**
	 * Servicio para obtener un Armario por Id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "porid/{id}", method = RequestMethod.POST)
	public ResponseEntity<Armario> obtenerArmarioPorId(@PathVariable("id") Long id) throws Exception {
		Optional<Armario> armario = armarioService.obtenerArmarioPorId(id);
		if (armario.isPresent()) {
			return ResponseEntity.ok(armario.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
