/**
 * 
 */
package com.insitel.iot.repositories;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.InterfazArmarioEvento;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface IasEventosRepository extends CrudRepository<InterfazArmarioEvento, Long> {
	
	/**
	 * Query para obtener los eventos de todas las IAs en un rango de fechas y horas
	 * @param fechaI
	 * @param fechaF
	 * @param horaI
	 * @param horaF
	 * @return
	 */
	@Query(value = "select * from iot_ia_events "
			+ "	where ia_eve_date between ?1 and ?2 "
			+ "	and ia_eve_time between ?3 and ?4", nativeQuery = true)
	public List<Object[]> obtenerEventosIasEntreFechasYHoras(Date fechaI, 
			Date fechaF, LocalTime horaI, LocalTime horaF);
	
	/**
	 * Query para obtener todos los eventos de las IAs en un rango de fecha y hora filtrado por tipo de evento
	 * @param fechaI
	 * @param fechaF
	 * @param horaI
	 * @param horaF
	 * @param tipo
	 * @return
	 */
	@Query(value = "select * from iot_ia_events "
			+ "	where ia_eve_date between ?1 and ?2 "
			+ "	and ia_eve_time between ?3 and ?4"
			+ " and ia_eve_name = ?5", nativeQuery = true)
	public List<Object[]> obtenerEventosIasEntreRangoFiltrado(Date fechaI, Date 
			fechaF, LocalTime horaI, LocalTime horaF, String tipo);

}
