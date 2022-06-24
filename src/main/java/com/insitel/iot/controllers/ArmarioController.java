/**
 * 
 */
package com.insitel.iot.controllers;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
import com.insitel.iot.models.Evento;
import com.insitel.iot.models.RespuestaArmAbiertoYUserDTO;
import com.insitel.iot.models.RespuestaEstadosArmariosDTO;
import com.insitel.iot.services.ArmarioService;
import com.insitel.iot.services.EventoService;

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

	@Autowired
	EventoService eventoService;

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
		String direccion = armario.getDir();
		String distrito = armario.getDist();
		Double latitud = armario.getLat();
		Double longitud = armario.getLon();

		Optional<Armario> encontrado = armarioService.obtenerArmarioPorId(id);
		if (encontrado.isPresent()) {
			Armario aGrabar = encontrado.get();
			aGrabar.setDir(direccion);
			aGrabar.setDist(distrito);
			aGrabar.setLat(latitud);
			aGrabar.setLon(longitud);

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
	 * 
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
			aGrabar.setEst(armario.getEst());

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

	/**
	 * Método para obtener los estados de todos los armarios del CR
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "estados", method = RequestMethod.GET)
	public List<Object[]> obtenerEstadosTodosArmarios() throws Exception {
		return armarioService.obtenerEstadosTodosArmarios();
	}

	/**
	 * Método para obtener lista de los armarios activos con servo en falla desde
	 * fecha y hora
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "servof", method = RequestMethod.GET)
	public ResponseEntity<List<RespuestaEstadosArmariosDTO>> ObtenerArmariosConServoFalla() throws Exception {
		Optional<ArrayList<Armario>> armarios = armarioService.ObtenerArmariosConServoFalla();
		String evento = "E17"; // DAÑO_SERVO
		if (armarios.isPresent()) {
			List<Armario> lisArmarios = new ArrayList<Armario>(armarios.get());
			List<RespuestaEstadosArmariosDTO> lstResp = new ArrayList<>();

			lstResp = llenarTablaEventos(lisArmarios, evento);

			return ResponseEntity.ok(lstResp);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	/**
	 * Método para obtener la lista de armarios activos con portadora o
	 * telealimentación en falla desde fecha y hora
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "portatelenf", method = RequestMethod.GET)
	public ResponseEntity<List<RespuestaEstadosArmariosDTO>> obtenerArmariosConPortOTelEnFalla() throws Exception {
		Optional<ArrayList<Armario>> armarios = armarioService.obtenerArmariosConPortOTelEnFalla();

		if (armarios.isPresent()) {
			List<Armario> lisArmarios = new ArrayList<Armario>(armarios.get());
			List<RespuestaEstadosArmariosDTO> lstResp = new ArrayList<>();

			lstResp = llenarTablaEventosTelePorta(lisArmarios);

			return ResponseEntity.ok(lstResp);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	/**
	 * Servicio que retorna los armarios con puerta entreabierta desde fecha y hora
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "ptaentrabie", method = RequestMethod.GET)
	public ResponseEntity<List<RespuestaEstadosArmariosDTO>> obtenerArmariosConPuertaEntrAbierta() throws Exception {
		Optional<ArrayList<Armario>> armarios = armarioService.obtenerArmariosConPuertaEntrAbierta();
		String evento = "E11"; // Puerta entreabierta
		if (armarios.isPresent()) {
			List<Armario> lisArmarios = new ArrayList<Armario>(armarios.get());
			List<RespuestaEstadosArmariosDTO> lstResp = new ArrayList<>();

			lstResp = llenarTablaEventos(lisArmarios, evento);

			return ResponseEntity.ok(lstResp);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	/**
	 * Servicio para obtener el listado de los armarios activos con puerta entreabierta
	 * y el ultimo usuario identificado en el armario
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "lastuser", method = RequestMethod.GET)
	public ResponseEntity<List<RespuestaArmAbiertoYUserDTO>> obtArmPtaAbiertaYUltUser() throws Exception {
		
		//Se obtienen los armarios con puerta entreabierta
		Optional<ArrayList<Armario>> armarios = armarioService.obtenerArmariosConPuertaEntrAbierta();
		String evento = "E05"; //Evento Apertura Autorizada
		
		if (armarios.isPresent()) {
			List<Armario> lisArmarios = new ArrayList<Armario>(armarios.get());
			List<RespuestaArmAbiertoYUserDTO> lstResp = new ArrayList<>();
			
			for (Armario a : lisArmarios) {
				RespuestaArmAbiertoYUserDTO eventos = new RespuestaArmAbiertoYUserDTO();
				
				List<Object[]> usuario = eventoService.obtenerEvUserPorEveYArmario(a.getNumArm().toString(), evento);
				for (Object[] o : usuario) {
					eventos.setCedula(o[1].toString());
					eventos.setNombre(o[2].toString());
					eventos.setLlave(o[0].toString());
					eventos.setEveUser(o[3].toString());
					eventos.setFechaApertura(Date.valueOf(o[4].toString()));
					eventos.setHoraApertura(LocalTime.parse(o[5].toString()));
				}
				eventos.setCr(a.getCr());
				eventos.setIa(a.getIa().toString());
				eventos.setCab(a.getNumArm().toString());
				eventos.setEve(a.getePta());
				
				lstResp.add(eventos);
			}
			return ResponseEntity.ok(lstResp);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	

	/**
	 * Método para llenar la tabla de respuesta de eventos
	 * 
	 * @param lisArmarios
	 * @param evento
	 * @return
	 */
	private List<RespuestaEstadosArmariosDTO> llenarTablaEventos(List<Armario> lisArmarios, String evento) {

		List<String> eve = new ArrayList<String>();
		eve.add(evento); // CIA_PORTADORA_NOK
		List<RespuestaEstadosArmariosDTO> lstResp = new ArrayList<>();

		for (Armario a : lisArmarios) {
			RespuestaEstadosArmariosDTO eventos = new RespuestaEstadosArmariosDTO();
			try {
				Evento ev = eventoService.obtenerPorEventYCabId(a.getNumArm().toString(), eve);
				eventos.setCab(a.getNumArm().toString());
				eventos.setCr(a.getCr());
				eventos.setIa(a.getIa().toString());
				eventos.setFecha(ev.getFecha());
				eventos.setHora(ev.getHora());
				eventos.setEve(ev.getNombre());
			} catch (Exception e) {
				continue;
			}
			lstResp.add(eventos);
		}
		return lstResp;
	}

	private List<RespuestaEstadosArmariosDTO> llenarTablaEventosTelePorta(List<Armario> lisArmarios) throws Exception {

		List<RespuestaEstadosArmariosDTO> lstResp = new ArrayList<>();
		List<String> porta = new ArrayList<String>();
		porta.add("I01"); // CIA_PORTADORA_NOK
		
		List<String> telea = new ArrayList<String>();
		telea.add("I03"); //CIA_BAJA_TELEALIMENTACION
		telea.add("I04"); // CIA_NO_TELEALIMENTACION
		telea.add("I05"); // CIA_SOBRETELEALIMENTACION
		
		for (Armario a : lisArmarios) {
			RespuestaEstadosArmariosDTO eventos = new RespuestaEstadosArmariosDTO();
			try {
				if (a.geteCarrier().equals(porta.get(0))) {
					eventos.setCab(a.getNumArm().toString());
					eventos.setCr(a.getCr());
					eventos.setIa(a.getIa().toString());
					Evento ev = eventoService.obtenerPorEventYCabId(a.getNumArm().toString(), porta);
					eventos.setFecha(ev.getFecha());
					eventos.setHora(ev.getHora());
					eventos.setEve(ev.getNombre());
					lstResp.add(eventos);
					eventos = new RespuestaEstadosArmariosDTO();
				} 
				if (a.geteEnergia().equals(telea.get(0)) || a.geteEnergia().equals(telea.get(1))
						|| a.geteEnergia().equals(telea.get(2))) {
					eventos.setCab(a.getNumArm().toString());
					eventos.setCr(a.getCr());
					eventos.setIa(a.getIa().toString());
					Evento ev = eventoService.obtenerPorEventYCabId(a.getNumArm().toString(), telea);
					eventos.setFecha(ev.getFecha());
					eventos.setHora(ev.getHora());
					eventos.setEve(ev.getNombre());
					lstResp.add(eventos);
				}
			} catch (Exception e) {
				lstResp.add(eventos);
				continue;
			}
			
		}
		return lstResp;
	}
}
