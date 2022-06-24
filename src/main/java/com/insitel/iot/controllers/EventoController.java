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

import com.insitel.iot.models.EventoUsuario;
import com.insitel.iot.models.FiltroEveUsrsKeysDTO;
import com.insitel.iot.models.FiltroEventosDTO;
import com.insitel.iot.models.RespuestaEveUserCodDTO;
import com.insitel.iot.models.RespuestaEventosDTO;
import com.insitel.iot.models.Usuario;
import com.insitel.iot.services.EventoService;
import com.insitel.iot.services.IasEventosService;
import com.insitel.iot.services.UsuarioService;
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
	
	@Autowired
	UsuarioService usuarioService;
	
	/**
	 * Servicio para obtener los eventos entre fecha y hora
	 * @param filtro
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "porfechayhora", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<RespuestaEventosDTO>> obtenerEventosEntreFechasyHoras(@RequestBody 
			FiltroEventosDTO filtro) throws Exception {
		
		Date fechaI = Utils.sumarDias(filtro.getFechaInicio(), 1);
		Date fechaF = Utils.sumarDias(filtro.getFechaFin(), 1);
		
		List<Object[]> lstEventosCab = eventoService.obtenerEventosEntreFechasyHoras(fechaI,
				fechaF, filtro.getHoraInicio(), filtro.getHoraFin());
		
		List<RespuestaEventosDTO> lstEvensCab = new ArrayList<>();
		lstEvensCab = llenarRptaCab(lstEventosCab);
		
		List<Object[]> lstEventosIa =  iasEventosService
				.obtenerEventosIasEntreFechasYHoras(fechaI, fechaF, filtro.getHoraInicio(), filtro.getHoraFin());
		
		List<RespuestaEventosDTO> lstEvensIas = new ArrayList<>();
		lstEvensIas = llenarRptaIas(lstEventosIa);
		
		List<RespuestaEventosDTO> lstResp = new ArrayList<RespuestaEventosDTO>(lstEvensCab);
		lstResp.addAll(lstEvensIas);
		
		if (lstResp != null && lstResp.size() > 0) {
			return ResponseEntity.ok(new ArrayList<>(lstResp));
		} else {
			return ResponseEntity.noContent().build();
		} 
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
		
		List<Object[]> lstEventosCab = eventoService.obtenerEventosEntreRangoConFiltro(fechaI,
				fechaF, filtro.getHoraInicio(), filtro.getHoraFin(), filtro.getTipoEvento());
		
		List<RespuestaEventosDTO> lstEvensCab = new ArrayList<>();
		lstEvensCab = llenarRptaCab(lstEventosCab);
		
		List<Object[]> lstEventosIa =  iasEventosService
				.obtenerEventosIasEntreFechasYHorasFiltrado(fechaI, fechaF, filtro.getHoraInicio(), 
						filtro.getHoraFin(), filtro.getTipoEvento());
		
		List<RespuestaEventosDTO> lstEvensIas = new ArrayList<>();
		lstEvensIas = llenarRptaIas(lstEventosIa);
		
		List<RespuestaEventosDTO> lstResp = new ArrayList<RespuestaEventosDTO>(lstEvensCab);
		lstResp.addAll(lstEvensIas);
		
		if (lstResp != null && lstResp.size() > 0) {
			return ResponseEntity.ok(new ArrayList<>(lstResp));
		} else {
			return ResponseEntity.noContent().build();
		} 
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
	 * Método para llenar la tabla de respuesta con eventos de Armarios
	 * @param lstEventos
	 * @return
	 */
	public List<RespuestaEventosDTO> llenarRptaCab(List<Object[]> lstEventos) {
		
		List<RespuestaEventosDTO> lstEvensCab = new ArrayList<>();
		
		for (Object[] objetos : lstEventos) {
			RespuestaEventosDTO eventos = new RespuestaEventosDTO();
			eventos.setId(objetos[0].toString());
			eventos.setFecha(Date.valueOf(objetos[1].toString()));
			eventos.setEstim(Boolean.parseBoolean(objetos[2].toString()));
			eventos.setHora(LocalTime.parse(objetos[3].toString()));
			eventos.setCr(Long.parseLong(objetos[4].toString()));
			eventos.setEve(objetos[5].toString());
			eventos.setCab(objetos[6].toString());
			eventos.setIa(objetos[7].toString());
			eventos.setSc(Boolean.parseBoolean(objetos[8].toString()));
			lstEvensCab.add(eventos);
		}
		return lstEvensCab;
	}
	
	/**
	 * Método para llenar la tabla de respuesta con eventos de IAs
	 * @param lstEventos
	 * @return
	 */
	public List<RespuestaEventosDTO> llenarRptaIas(List<Object[]> lstEventos) {
		
		List<RespuestaEventosDTO> lstEvensIas = new ArrayList<>();
		for (Object[] objetos : lstEventos) {
			RespuestaEventosDTO eventos = new RespuestaEventosDTO();
			eventos.setId(objetos[0].toString());
			eventos.setFecha(Date.valueOf(objetos[1].toString()));
			eventos.setHora(LocalTime.parse(objetos[2].toString()));
			eventos.setCr(Long.parseLong(objetos[3].toString()));
			eventos.setIa(objetos[4].toString());
			eventos.setEve(objetos[5].toString());
			eventos.setCab("No aplica");
			lstEvensIas.add(eventos);
		}
		return lstEvensIas;
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
	
	/**
	 * Método para obtener eventos de usuario por codigo entre fechas
	 * @param filtro
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "usuario/entrefechaporcod", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<RespuestaEveUserCodDTO>> obtenerEvenUserPorCodYFecha(@RequestBody
			FiltroEveUsrsKeysDTO filtro) throws Exception {
		
		Date fechaI = Utils.sumarDias(filtro.getFechaInicio(), 1);
		Date fechaF = Utils.sumarDias(filtro.getFechaFin(), 1);
		
		List<Object[]> lstEventos = eventoService.obtenerEvenUserPorCodYFecha(fechaI, fechaF, 
				filtro.getCod());
		List<RespuestaEveUserCodDTO> lstResp = new ArrayList<>();
		
		for (Object[] objetos : lstEventos) {
			RespuestaEveUserCodDTO eventos = new RespuestaEveUserCodDTO();
			eventos.setCodigoLlave(objetos[0].toString());
			eventos.setIdentUsuario(objetos[1].toString());
			eventos.setNombreUser(objetos[2].toString());
			eventos.setEvento(objetos[3].toString());
			eventos.setFecha(Date.valueOf(objetos[4].toString()));
			eventos.setHora(LocalTime.parse(objetos[5].toString()));
			eventos.setEstimada(Boolean.valueOf(objetos[6].toString()));
			eventos.setCr(objetos[7].toString());
			eventos.setIa(objetos[8].toString());
			eventos.setArmario(objetos[9].toString());
			lstResp.add(eventos);
		}
		if (lstResp != null && lstResp.size() > 0) {
			return ResponseEntity.ok(new ArrayList<>(lstResp));
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	/**
	 * Servicio para obtener el listado de los usuarios activos que no han usado 
	 * el sistema en los últimos 7 dias
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "usuario/nousa", method = RequestMethod.POST)
	public ResponseEntity<List<Usuario>> obtenerUserSinUsarXdias(@RequestBody FiltroEventosDTO filtro) throws Exception {
		
		Date fechaI = Utils.sumarDias(filtro.getFechaInicio(), 1);
		Date fechaF = Utils.sumarDias(filtro.getFechaFin(), 1);
		
		List<Usuario> usrResp = new ArrayList<>();
		ArrayList<Usuario> usuarios = usuarioService.obtenerUsersActivos();
		
		for (Usuario us : usuarios) {
			Optional<Object[]> conEvento = eventoService.obtenerUsersUsaron(fechaI, 
					fechaF, us.getDocIdentidad());
			if (conEvento.get().length == 0) {
				usrResp.add(us);
			}
		}
		if (usrResp != null && usrResp.size() > 0) {
			return ResponseEntity.ok(new ArrayList<>(usrResp));
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
}
