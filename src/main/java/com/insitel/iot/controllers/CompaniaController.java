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
import com.insitel.iot.models.Compania;
import com.insitel.iot.services.CompaniaService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/iot/comp")
public class CompaniaController {
	
	@Autowired
	CompaniaService companiaService;
	
	/**
	 * Servicio para obtener toas las Compañias
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "obtenertodas", method = RequestMethod.GET)
	public ArrayList<Compania> obtenerTodasCias() throws Exception {
		return companiaService.obtenerTodasCompanias();
	}
	
	/**
	 * Servicio para crear una nueca Compañia
	 * @param compania
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "crear", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> crearCompania(@RequestBody Compania compania) throws Exception {
		
		String message = "";
		companiaService.guardarCompañia(compania);
		message = "Se creó la Compañía exitosamente";
		return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
	}
	
	/**
	 * Servicio para guardar o actualizar campos de una Compañia
	 * @param compania
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "actualizar", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> actualizarCia(@RequestBody Compania compania) throws Exception {
		
		String message = "";
		Long id = compania.getId();
		String nit = compania.getNit();
		String contacto = compania.getContacto();
		String correo = compania.getCorreo();
		String direccion = compania.getDireccion();
		Double latitud = compania.getLatitud();
		Double longitud = compania.getLongitud();
		String nombre = compania.getNombre();
		Long paisId = compania.getPaisId();
		String telefono = compania.getTelefono();
		
		Optional<Compania> encontrada = companiaService.obtenerCompaniaPorId(id);
		if (encontrada.isPresent()) {
			Compania aGrabar = encontrada.get();
			aGrabar.setNit(nit);
			aGrabar.setContacto(contacto);
			aGrabar.setCorreo(correo);
			aGrabar.setDireccion(direccion);
			aGrabar.setLatitud(latitud);
			aGrabar.setLongitud(longitud);
			aGrabar.setNombre(nombre);
			aGrabar.setPaisId(paisId);
			aGrabar.setTelefono(telefono);
			aGrabar.setTipo(compania.getTipo());
			
			companiaService.guardarCompañia(aGrabar);
			message = "Se actualizó la Compañía exitosamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar Compañía";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}
		
	}
	
	/**
	 * Servicio para cambiar el estado de la Compañía
	 * @param compania
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "cambiarest", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> cambiarEstadoCia(@RequestBody Compania compania) throws Exception {
		
		String message = "";
		Long id = compania.getId();
		
		Optional<Compania> encontrada = companiaService.obtenerCompaniaPorId(id);
		if (encontrada.isPresent()) {
			Compania aGrabar = encontrada.get();
			aGrabar.setCodigo(compania.getCodigo());
			companiaService.guardarCompañia(aGrabar);
			message = "Se cambió el estado de la Compania exitosamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar Compañía";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}
		
	}
	
	/**
	 * Servicio para obtener Compañia por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "porid/{id}", method = RequestMethod.POST)
	public ResponseEntity<Compania> obtenerCiasPorId(@PathVariable("id") Long id) throws Exception {
		Optional<Compania> cia = companiaService.obtenerCompaniaPorId(id);
		if (cia.isPresent()) {
			return ResponseEntity.ok(cia.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
