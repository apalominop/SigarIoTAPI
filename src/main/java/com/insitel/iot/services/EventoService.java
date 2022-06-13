/**
 * 
 */
package com.insitel.iot.services;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
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

}
