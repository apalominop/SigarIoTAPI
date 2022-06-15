/**
 * 
 */
package com.insitel.iot.repositories;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.Evento;
import com.insitel.iot.models.EventoUsuario;

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
	
	/**
	 * Query para obtener los eventos de usuario por documento de usuario entre dos fechas
	 * @param fechaI
	 * @param fechaF
	 * @param documento
	 * @return
	 */
	@Query(value = "select * from iot_user_event "
			+ "where uev_date >= ?1 "
			+ "and uev_date <= ?2 "
			+ "and uev_doc_id = ?3 ", nativeQuery = true)
	public List<Object[]> obtenerEventsUserEntreFechas(Date fechaI, 
			Date fechaF, String documento);
	
	/**
	 * Query para obtener los eventos de una llave entre dos fechas
	 * @param fechaI
	 * @param fechaF
	 * @param key
	 * @return
	 */
	@Query(value = "select * from iot_user_event "
			+ "where uev_date >= ?1 "
			+ "and uev_date <= ?2 "
			+ "and uev_key_cod = ?3 ", nativeQuery = true)
	public List<Object[]> obtenerEvensKeyEntreFechas(Date fechaI, 
			Date fechaF, String key);
	
	/**
	 * Query para obtener los eventos de una llave entre fecha y hora
	 * @param fechaI
	 * @param fechaF
	 * @param horaI
	 * @param horaF
	 * @param key
	 * @return
	 */
	@Query(value = "select * from iot_user_event "
			+ "where uev_date >= ?1 "
			+ "and uev_date <= ?2 "
			+ "and uev_hour between ?3 and ?4 "
			+ "and uev_key_cod = ?5 ", nativeQuery = true)
	public List<Object[]> obtenerEvensKeyEntreFechaYHora(Date fechaI, Date fechaF,
			LocalTime horaI, LocalTime horaF, String key);
	
	/**
	 * Query para obtener todos los eventos de usuario entre fecha y hora
	 * @param fechaI
	 * @param fechaF
	 * @param horaI
	 * @param horaF
	 * @return
	 */
	@Query(value = "select * from iot_user_event "
			+ "where uev_date >= ?1 "
			+ "and uev_date <= ?2 "
			+ "and uev_hour between ?3 and ?4 ", nativeQuery = true)
	public List<Object[]> obtenerEventsEntreFechaYHora(Date fechaI, Date fechaF,
			LocalTime horaI, LocalTime horaF);
	
}
