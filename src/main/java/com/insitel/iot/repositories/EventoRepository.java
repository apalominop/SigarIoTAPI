/**
 * 
 */
package com.insitel.iot.repositories;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.Evento;

/**
 * @author JAgustín Palomino Pardo
 *
 */
@Repository
public interface EventoRepository extends CrudRepository<Evento, Long> {
	
	/**
	 * Query para obtener los eventros entre Fecha Inicial y Fehca Final y entre Hora Inicial y Hora Final
	 * @param fechaI
	 * @param fechaF
	 * @param horaI
	 * @param horaF
	 * @return
	 */
	@Query(value = "select * from iot_events "
			+ "where eve_date >= ?1 "
			+ "and eve_date <= ?2 "
			+ "and eve_hour >= ?3 "
			+ "and eve_hour <= ?4", nativeQuery = true)
	public Optional<ArrayList<Evento>> obtenerEventosEntreFechasYHoras(Date fechaI, Date fechaF, LocalTime horaI, LocalTime horaF);

	/**
	 * Query para obtener eventos en un rango de fechas y horas filtrado por tipo de evento
	 * @param fechaI
	 * @param fechaF
	 * @param horaI
	 * @param horaF
	 * @param tipo
	 * @return
	 */
	@Query(value = "select * from iot_events "
			+ "where eve_date >= ?1 "
			+ "and eve_date <= ?2 "
			+ "and eve_hour >= ?3 "
			+ "and eve_hour <= ?4 "
			+ "and eve_name = ?5", nativeQuery = true)
	public Optional<ArrayList<Evento>> obtenerEventosEntreRangoConFiltro(Date fechaI, 
				Date fechaF, LocalTime horaI, LocalTime horaF, String tipo);
	
}
