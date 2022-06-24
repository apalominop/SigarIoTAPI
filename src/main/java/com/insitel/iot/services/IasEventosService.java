/**
 * 
 */
package com.insitel.iot.services;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.repositories.IasEventosRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Service
public class IasEventosService {

	@Autowired
	IasEventosRepository iasEventosRepository;
	
	/**
	 * Método para obtener todos los eventos de las IAs en unrango de fecha y hora
	 * @param fechaI
	 * @param fechaF
	 * @param horaI
	 * @param horaF
	 * @return
	 * @throws Exception
	 */
	public List<Object[]> obtenerEventosIasEntreFechasYHoras(Date fechaI,
			Date fechaF, LocalTime horaI, LocalTime horaF) throws Exception {
		
		return iasEventosRepository.obtenerEventosIasEntreFechasYHoras(fechaI, fechaF, horaI, horaF);
	}
	
	/**
	 * Método para obtener todos los eventaos de las IAs en un rango de fecha y hora filtrado por
	 * nombre de evento
	 * @param fechaI
	 * @param fechaF
	 * @param horaI
	 * @param horaF
	 * @param tipo
	 * @return
	 * @throws Exception
	 */
	public List<Object[]> obtenerEventosIasEntreFechasYHorasFiltrado(Date fechaI,
			Date fechaF, LocalTime horaI, LocalTime horaF, String tipo) throws Exception {
		
		return iasEventosRepository.obtenerEventosIasEntreRangoFiltrado(fechaI, fechaF, horaI, horaF, tipo);
	}
	
}
