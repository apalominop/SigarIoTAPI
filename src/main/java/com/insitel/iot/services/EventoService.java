/**
 * 
 */
package com.insitel.iot.services;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
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
	public Optional<ArrayList<Evento>> obtenerEventosEntreFechasyHoras(Date fechaI, Date fechaF,
			LocalTime horaI, LocalTime horaF) throws Exception {
		
		return eventoRepository.obtenerEventosEntreFechasYHoras(fechaI, fechaF, horaI, horaF);
	}
	
	/**
	 * Método para obtener los eventos en un rango de fechas y horas filtrado por tipo de evento
	 * @param filtro
	 * @return
	 * @throws Exception
	 */
	public Optional<ArrayList<Evento>> obtenerEventosEntreRangoConFiltro(Date fechaI, Date fechaF,
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
	
}
