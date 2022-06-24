/**
 * 
 */
package com.insitel.iot.services;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.Evento;
import com.insitel.iot.repositories.EventoRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */
@Service
public class EventoService {
	
	@Autowired
	EventoRepository eventoRepository;
	
	/**
	 * Método para obtener los eventos entre dos fechas determinadas y entre dos horas determinadas
	 * @param filtro
	 * @return
	 * @throws Exception
	 */
	public List<Object[]> obtenerEventosEntreFechasyHoras(Date fechaI, Date fechaF,
			LocalTime horaI, LocalTime horaF) throws Exception {
		
		return eventoRepository.obtenerEventosEntreFechasYHoras(fechaI, fechaF, horaI, horaF);
	}
	
	/**
	 * Método para obtener los eventos en un rango de fechas y horas filtrado por tipo de evento
	 * @param filtro
	 * @return
	 * @throws Exception
	 */
	public List<Object[]> obtenerEventosEntreRangoConFiltro(Date fechaI, Date fechaF,
			LocalTime horaI, LocalTime horaF, String tipo) throws Exception {

		return eventoRepository.obtenerEventosEntreRangoConFiltro(fechaI, fechaF, horaI, horaF, tipo);
	}
	
	/**
	 * Método para obtener los eventos de usuario por documento de usuario entre dos fechas
	 * @param fechaI
	 * @param fechaF
	 * @param documento
	 * @return
	 * @throws Exception
	 */
	public List<Object[]> obtenerEventsUserEntreFechas(Date fechaI, 
			Date fechaF, String documentoUser) throws Exception {
		return eventoRepository.obtenerEventsUserEntreFechas(fechaI, fechaF, documentoUser);
	}

	/**
	 * Método para obtener los eventos por llave entre dos fechas
	 * @param fechaI
	 * @param fechaF
	 * @param codKey
	 * @return
	 * @throws Exception
	 */
	public List<Object[]> obtenerEvensKeyEntreFechas(Date fechaI, 
			Date fechaF, String codKey) throws Exception {
		return eventoRepository.obtenerEvensKeyEntreFechas(fechaI, fechaF, codKey);
	}
	
	/**
	 * Método para obtener los eventos por llave entre fechas y horas
	 * @param fechaI
	 * @param fechaF
	 * @param horaI
	 * @param horaF
	 * @param codKey
	 * @return
	 * @throws Exception
	 */
	public List<Object[]> obtenerEvensKeyEntreFechaYHora(Date fechaI, Date fechaF, 
			LocalTime horaI, LocalTime horaF, String codKey) throws Exception {
		return eventoRepository.obtenerEvensKeyEntreFechaYHora(fechaI, fechaF, horaI, horaF, codKey);
	}
	
	/**
	 * Método para obtener todos los eventos de Usuario entre fecha y hora
	 * @param fechaI
	 * @param fechaF
	 * @param horaI
	 * @param horaF
	 * @return
	 * @throws Exception
	 */
	public List<Object[]> obtenerEventsEntreFechaYHora(Date fechaI, Date fechaF, 
			LocalTime horaI, LocalTime horaF) throws Exception {
		return eventoRepository.obtenerEventsEntreFechaYHora(fechaI, fechaF, horaI, horaF);
		
	}
	
	/**
	 * Método para obtener los eventos por codigo  entre dos fechas
	 * @param fechaI
	 * @param fechaF
	 * @param cod
	 * @return
	 * @throws Exception
	 */
	public List<Object[]> obtenerEvenUserPorCodYFecha(Date fechaI, Date fechaF, String cod) throws Exception {
		return eventoRepository.obtenerEvenUserPorCodYFecha(fechaI, fechaF, cod);
	}
	
	/**
	 * Método para obtener lista de un armario por un evento determinado
	 * @param cabId
	 * @param evento
	 * @return
	 * @throws Exception
	 */
	public Evento obtenerPorEventYCabId(String cabNum, List<String> evento) throws Exception {
		return eventoRepository.obtenerPorEventYCabId(cabNum, evento);
	}
	
	/**
	 * Método para obtener el último evento en un determinado armario
	 * @param cabNum
	 * @param evento
	 * @return
	 * @throws Exception
	 */
	public List<Object[]> obtenerEvUserPorEveYArmario(String cabNum, String evento) throws Exception {
		return eventoRepository.obtenerEvUserPorEveYArmario(cabNum, evento);
	}

	/**
	 * Método para obtener los usuarios que han tenido evento(s) en los Armarios 
	 * entre dos fechas
	 * @param fechaI
	 * @param fechaF
	 * @param cedula
	 * @return
	 * @throws Exception
	 */
	public Optional<Object[]> obtenerUsersUsaron(Date fechaI, Date fechaF, String cedula)
			throws Exception {
		return eventoRepository.obtenerUsersUsaron(fechaI, fechaF, cedula);
	}
	
}
