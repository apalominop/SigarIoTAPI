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
import com.insitel.iot.models.DiaFestivo;
import com.insitel.iot.services.DiaFestivoService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@RestController
@RequestMapping("/iot/festivo")
public class DiaFestivoController {
	
	@Autowired
	DiaFestivoService diaFestivoService;
	
	/**
	 * Servicio para obtener todos los Festivos
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "obtenertodos", method = RequestMethod.GET)
	public ArrayList<DiaFestivo> obtenerTodosFestivos() throws Exception {
		return diaFestivoService.obtenerTodos();
	}
	
	/**
	 * Servicio para guardar y actualizar un Festivo
	 * @param festivo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "guardar", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> guardarFestivo(@RequestBody DiaFestivo festivo) throws Exception {
		
		String message = "";
		diaFestivoService.guardar(festivo);
		message = "Se grabó el Festivo exitosamente";
		return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
	}
	
	/**
	 * Servicio para obtener un Festico por id
	 * @param festivo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "porid/{id}", method = RequestMethod.POST)
	public ResponseEntity<DiaFestivo> obtenerFestivoPorId(@PathVariable("id") Long id) throws Exception {
		Optional<DiaFestivo> festivo = diaFestivoService.obtenerFestivoPorId(id);
		if (festivo.isPresent()) {
			return ResponseEntity.ok(festivo.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
