/**
 * 
 */
package com.insitel.iot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.Armario;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface ArmarioRepository extends CrudRepository<Armario, Long> {
	
	/**
	 * Query para obtener los estados de todos los armarios del CR
	 * @return
	 */
	@Query(value = "select cab_id, cab_status, cab_door_status, cab_battery_status, cab_reader_status,"
			+ "	   cab_servo_status, cab_position_status, cab_carrier_status,"
			+ "	   cab_power_status, cab_activation_status, cab_masterkey_status,"
			+ "	   cab_sleep_rfid_status, cab_sensor1_status, cab_sensor2_status,"
			+ "	   cab_sensor3_status, cab_sensor4_status"
			+ "	   from iot_cabinet order by cab_id", nativeQuery = true)
	public List<Object[]> obtenerEstadosTodosArmarios();
	
}
