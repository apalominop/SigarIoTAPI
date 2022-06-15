/**
 * 
 */
package com.insitel.iot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Date;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insitel.iot.models.Evento;
import com.insitel.iot.models.EventoUsuario;
import com.insitel.iot.models.FiltroEveUsrsKeysDTO;
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
	
	/**
	 * Servicio para obtener los eventos por documento de usuario entre dos fechas
	 * @param filtro
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "usuario/pordocentrefechas", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<EventoUsuario>> obtenerEventsUserEntreFechas(@RequestBody 
			FiltroEveUsrsKeysDTO filtro) throws Exception {
		
		Date fechaI = Utils.sumarDias(filtro.getFechaInicio(), 1);
		Date fechaF = Utils.sumarDias(filtro.getFechaFin(), 1);
		
		List<Object[]> lstEventos = eventoService.obtenerEventsUserEntreFechas(fechaI, fechaF, 
				filtro.getDocumentoUser());
		
		List<EventoUsuario> lstEvensUser = new ArrayList<>();
		lstEvensUser = llenarTablaRespuesta(lstEventos);
		
		if (lstEvensUser != null && lstEvensUser.size() > 0) {
			return ResponseEntity.ok(new ArrayList<>(lstEvensUser));
		} else {
			return ResponseEntity.noContent().build();
		} 
	}
	
	/**
	 * Método para llenar la tabla de respuesta de eventos de Usuario
	 * @param lstEventos
	 * @return
	 */
	public List<EventoUsuario> llenarTablaRespuesta(List<Object[]> lstEventos) {
	
		List<EventoUsuario> lstEvensUser = new ArrayList<>();
		
		for (Object[] objetos : lstEventos) {
			EventoUsuario eventos = new EventoUsuario();
			eventos.setId(objetos[0].toString());
			eventos.setDocumento(objetos[1].toString());
			eventos.setEventoCodigo(objetos[2].toString());
			eventos.setCodigoLlave(objetos[3].toString());
			eventos.setFecha(Date.valueOf(objetos[4].toString()));
			eventos.setFechaEstimada(Boolean.parseBoolean(objetos[4].toString()));
			eventos.setHora(LocalTime.parse(objetos[6].toString()));
			eventos.setIdCR(Long.parseLong(objetos[7].toString()));
			eventos.setNumeroArmario(objetos[8].toString());
			eventos.setNumeroIA(objetos[9].toString());
			lstEvensUser.add(eventos);
		}
		return lstEvensUser;
	}
	
	/**
	 * Servicio para obtener los eventos por llave entre dos fechas
	 * @param filtro
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "usuario/porkeyentrefechas", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<EventoUsuario>> obtenerEvensKeyEntreFechas(@RequestBody 
			FiltroEveUsrsKeysDTO filtro) throws Exception {
		
		Date fechaI = Utils.sumarDias(filtro.getFechaInicio(), 1);
		Date fechaF = Utils.sumarDias(filtro.getFechaFin(), 1);
		
		List<Object[]> lstEventos = eventoService.obtenerEvensKeyEntreFechas(fechaI, fechaF, 
				filtro.getCodKey());
		List<EventoUsuario> lstEvensUser = new ArrayList<>();
		lstEvensUser = llenarTablaRespuesta(lstEventos);
		
		if (lstEvensUser != null && lstEvensUser.size() > 0) {
			return ResponseEntity.ok(new ArrayList<>(lstEvensUser));
		} else {
			return ResponseEntity.noContent().build();
		} 
	}
	
	/**
	 * Servicio para obtener los eventos de Usaurio por llave entre fecha y hora
	 * @param filtro
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "usuario/porkeyentrefechayhora", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<EventoUsuario>> obtenerEvensKeyEntreFechaYHora(@RequestBody 
			FiltroEveUsrsKeysDTO filtro) throws Exception {
		
		Date fechaI = Utils.sumarDias(filtro.getFechaInicio(), 1);
		Date fechaF = Utils.sumarDias(filtro.getFechaFin(), 1);
		
		List<Object[]> lstEventos = eventoService.obtenerEvensKeyEntreFechaYHora(fechaI, fechaF, filtro.getHoraInicio(),
				filtro.getHoraFin(), filtro.getCodKey());
		List<EventoUsuario> lstEvensUser = new ArrayList<>();
		lstEvensUser = llenarTablaRespuesta(lstEventos);
		
		if (lstEvensUser != null && lstEvensUser.size() > 0) {
			return ResponseEntity.ok(new ArrayList<>(lstEvensUser));
		} else {
			return ResponseEntity.noContent().build();
		} 
	}
	
	/**
	 * Servicio para obtener todos los eventos de usuario entre fecha y hora
	 * @param filtro
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "usuario/entrefechayhora", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<EventoUsuario>> obtenerEventsEntreFechaYHora(@RequestBody 
			FiltroEveUsrsKeysDTO filtro) throws Exception {
	
		Date fechaI = Utils.sumarDias(filtro.getFechaInicio(), 1);
		Date fechaF = Utils.sumarDias(filtro.getFechaFin(), 1);
		
		List<Object[]> lstEventos = eventoService.obtenerEventsEntreFechaYHora(fechaI, fechaF, 
				filtro.getHoraInicio(), filtro.getHoraFin());
		List<EventoUsuario> lstEvensUser = new ArrayList<>();
		lstEvensUser = llenarTablaRespuesta(lstEventos);
		
		if (lstEvensUser != null && lstEvensUser.size() > 0) {
			return ResponseEntity.ok(new ArrayList<>(lstEvensUser));
		} else {
			return ResponseEntity.noContent().build();
		} 
	}
	
}
