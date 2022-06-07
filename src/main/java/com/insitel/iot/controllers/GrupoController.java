/**
 * 
 */
package com.insitel.iot.controllers;

import java.sql.Date;
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
import com.insitel.iot.models.Grupo;
import com.insitel.iot.services.GrupoService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/iot/grupo")
public class GrupoController {
	
	@Autowired
	GrupoService grupoService;
	
	/**
	 * Servicio para obtener todos los Grupos
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "obtenertodos", method = RequestMethod.GET)
	public ArrayList<Grupo> obtenerTodosGrupos() throws Exception {
		return grupoService.obtenerGrupos();
	}
	
	/**
	 * Servicio para crear un nuevo permiso
	 * @param grupo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "crear", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> crearGrupo(@RequestBody Grupo grupo) throws Exception {
		
		String message = "";
		grupoService.guardarGrupo(grupo);
		message = "Se actualizó el Grupo exitosamente";
		return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
	}
	
	/**
	 * Servicio para guardar y actualizar un Grupo
	 * @param grupo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "actualizar", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> actualizarGrupo(@RequestBody Grupo grupo) throws Exception {
		
		String message = "";
		Long id = grupo.getId();
		boolean diaFestivo = grupo.isDiaFestivo();
		boolean domingo = grupo.isDomingo();
		Date finFecha = grupo.getFinFecha();
		String finHora = grupo.getFinHora();
		Date inicioFecha = grupo.getInicioFecha();
		String inicioHora = grupo.getInicioHora();
		String nombre = grupo.getNombre();
		String responsable = grupo.getResponsable();
		boolean sabado = grupo.isSabado();
		
		Optional<Grupo> encontrado = grupoService.obtenerGrupoPorId(id);
		if (encontrado.isPresent()) {
			Grupo aGrabar = encontrado.get();
			aGrabar.setCompania(grupo.getCompania());
			aGrabar.setDiaFestivo(diaFestivo);
			aGrabar.setDomingo(domingo);
			aGrabar.setFinFecha(finFecha);;
			aGrabar.setFinHora(finHora);
			aGrabar.setInicioFecha(inicioFecha);
			aGrabar.setInicioHora(inicioHora);
			aGrabar.setNombre(nombre);
			aGrabar.setResponsable(responsable);
			aGrabar.setSabado(sabado);
			
			grupoService.guardarGrupo(aGrabar);
			message = "Se actualizó el Grupo exitosamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar Grupo";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}
		
	}
	
	/**
	 * Servicio para cambiar el estado de un Grupo
	 * @param grupo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "cambiarest", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> cambiarEstadoGrupo(@RequestBody Grupo grupo) throws Exception {
		
		String message = "";
		Long id = grupo.getId();
		
		Optional<Grupo> encontrado = grupoService.obtenerGrupoPorId(id);
		if (encontrado.isPresent()) {
			Grupo aGrabar = encontrado.get();
			aGrabar.setEstado(grupo.getEstado());
			
			grupoService.guardarGrupo(aGrabar);
			message = "Se cambió el estado del Grupo exitosamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar Grupo";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}
	}
	
	/**
	 * Servicio para obtener Grupo por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "porid/{id}", method = RequestMethod.POST)
	public ResponseEntity<Grupo> obtenerGrupoPorId(@PathVariable("id") Long id) throws Exception {
		Optional<Grupo> grupo = grupoService.obtenerGrupoPorId(id);
		if (grupo.isPresent()) {
			return ResponseEntity.ok(grupo.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
