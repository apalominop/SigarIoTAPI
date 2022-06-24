/**
 * 
 */
package com.insitel.iot.repositories;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.Evento;

/**
 * @author Agustín Palomino Pardo
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
	public List<Object[]> obtenerEventosEntreFechasYHoras(Date fechaI, Date fechaF, LocalTime horaI, LocalTime horaF);

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
	public List<Object[]> obtenerEventosEntreRangoConFiltro(Date fechaI, 
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
	
	/**
	 * Query para obtener los eventos de usuario por codigo entre fechas
	 * puede ser usado para el informe de usuarios que han usado el sistema los últimos 7 dias
	 * @param fechaI
	 * @param fechaF
	 * @param cod
	 * @return
	 */
	@Query(value = "select uev_key_cod as keyCod"
			+ "   ,uev_doc_id as docUser"
			+ "	  ,usr_name || ' ' || usr_lastname as nombreUser"
			+ "	  ,ref_name as evento"
			+ "	  ,uev_date as fecha"
			+ "	  ,uev_hour as hora"
			+ "	  ,uev_date_estim as estimada"
			+ "	  ,mcr_name as cr"
			+ "	  ,uev_ia_num as ia"
			+ "	  ,uev_cab_num as armario"
			+ "    from iot_user_event"
			+ "	inner join iot_user on uev_doc_id = usr_doc_id"
			+ "	inner join iot_reference on uev_eve_cod = ref_code"
			+ "	inner join iot_mcr on uev_cr_id = mcr_id"
			+ "	where uev_date between ?1 and ?2"
			+ "	and uev_eve_cod = ?3"
			+ "	group by keyCod, docUser, nombreUser, evento, fecha, hora, estimada, cr, ia, armario", nativeQuery = true)
	public List<Object[]> obtenerEvenUserPorCodYFecha(Date fechaI, Date fechaF, String cod);
	
	/**
	 * Query para obtener el evento más reciente un armario
	 * @param cabId
	 * @param evento
	 * @return
	 */
	@Query(value ="select * from iot_events "
			+ "	where eve_cab_num = ?1 "
			+ "	and eve_name in ?2"
			+ "	order by eve_date desc, eve_hour desc"
			+ " limit 1", nativeQuery = true)
	public Evento obtenerPorEventYCabId(String cabNum, List<String> evento);
	
	/**
	 * Query para obtener el último evento en un determinado armario
	 * @param cabNum
	 * @param evento
	 * @return
	 */
	@Query(value = "select uev_key_cod"
			+ "   ,uev_doc_id"
			+ "	  ,usr_name || ' ' || usr_lastname as nombreUser"
			+ "	  ,uev_eve_cod"
			+ "	  ,uev_date"
			+ "	  ,uev_hour"
			+ " from iot_user_event "
			+ "     ,iot_user"
			+ "	where uev_doc_id = usr_doc_id "
			+ "	and uev_cab_num = ?1 "
			+ "	and uev_eve_cod = ?2"
			+ "	order by uev_date desc, uev_hour desc"
			+ "	limit 1", nativeQuery = true)
	public List<Object[]> obtenerEvUserPorEveYArmario(String cabNum, String evento);
	
	/**
	 * Query para obtener Listado de los usuarios con registro de actividad en los Armarios
	 * @param fechaI
	 * @param fechaF
	 * @param cedula
	 * @return
	 */
	@Query(value = "select * from iot_user_event"
			+ "	where uev_date between ?1 and ?2"
			+ "	and uev_doc_id = ?3"
			+ " limit 1", nativeQuery = true)
	Optional<Object[]> obtenerUsersUsaron(Date fechaI, Date fechaF, String cedula);
	
}
