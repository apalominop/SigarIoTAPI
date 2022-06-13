/**
 * 
 */
package com.insitel.iot.controllers;

import java.util.ArrayList;
import java.util.Optional;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insitel.iot.models.Evento;
import com.insitel.iot.models.FiltroEventosDTO;
import com.insitel.iot.models.InterfazArmarioEvento;
import com.insitel.iot.services.EventoService;
import com.insitel.iot.services.IasEventosService;
import com.insitel.iot.utils.Utils;

/**
 * @author Agustín Palomino Pardo
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/iot/evento")
public class EventoController {
	
	@Autowired
	EventoService eventoService;
	
	@Autowired
	IasEventosService iasEventosService;
	
	/**
	 * Servicio para obtener los eventos entre fecha y hora
	 * @param filtro
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "porfechayhora", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Object>> obtenerEventosEntreFechasyHoras(@RequestBody 
			FiltroEventosDTO filtro) throws Exception {
		
		Date fechaI = Utils.sumarDias(filtro.getFechaInicio(), 1);
		Date fechaF = Utils.sumarDias(filtro.getFechaFin(), 1);
		ArrayList<Object> respuesta = new ArrayList<>();
		
		Optional<ArrayList<Evento>> eventosCab = eventoService.obtenerEventosEntreFechasyHoras(fechaI,
				fechaF, filtro.getHoraInicio(), filtro.getHorafin());
		if (eventosCab.isPresent()) {
			respuesta.add(eventosCab);
		} 
		
		Optional<ArrayList<InterfazArmarioEvento>> eventosIas = iasEventosService
				.obtenerEventosIasEntreFechasYHoras(fechaI, fechaF, filtro.getHoraInicio(), filtro.getHorafin());
		if (eventosIas.isPresent()) {
			respuesta.add(eventosIas);
		}
		if (eventosCab.isEmpty() && eventosIas.isEmpty()){
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(respuesta);
	}
	
	/**
	 * Servicio para obtener los eventos entre un rango de fechas y horas filtrado por tipo de evento
	 * @param filtro
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "fechayhorafiltrado", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Object>> obtenerEventosEntreRangoConFiltro(@RequestBody 
			FiltroEventosDTO filtro) throws Exception {
		
		Date fechaI = Utils.sumarDias(filtro.getFechaInicio(), 1);
		Date fechaF = Utils.sumarDias(filtro.getFechaFin(), 1);
		ArrayList<Object> respuesta = new ArrayList<>();
		
		Optional<ArrayList<Evento>> eventosCab = eventoService.obtenerEventosEntreRangoConFiltro(fechaI,
				fechaF, filtro.getHoraInicio(), filtro.getHorafin(), filtro.getTipoEvento());
		if (eventosCab.isPresent()) {
			respuesta.add(eventosCab);
		} 
		
		Optional<ArrayList<InterfazArmarioEvento>> eventosIas = iasEventosService
				.obtenerEventosIasEntreFechasYHorasFiltrado(fechaI, fechaF, filtro.getHoraInicio(), 
						filtro.getHorafin(), filtro.getTipoEvento());
		if (eventosIas.isPresent()) {
			respuesta.add(eventosIas);
		}
		if (eventosCab.isEmpty() && eventosIas.isEmpty()){
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(respuesta);
	}

}
