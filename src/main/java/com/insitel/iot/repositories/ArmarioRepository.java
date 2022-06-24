/**
 * 
 */
package com.insitel.iot.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	/**
	 * Query para obtener el listado de los armarios activos con Servo en falla (cod E17)
	 * cod E22 armario activo
	 * @return
	 */
	@Query(value = "select * from iot_cabinet where cab_status = 'E22' and cab_servo_status = 'E17'", 
			nativeQuery = true)
	public Optional<ArrayList<Armario>> ObtenerArmariosConServoFalla();
	
	/**
	 * Query para obtener los armarios activos con portadora o telealimentación en falla
	 * @return
	 */
	@Query(value = "select * from iot_cabinet "
			+ "	where cab_status = 'E22' "
			+ "	and (cab_carrier_status = 'I01' or cab_power_status = 'I04' "
			+ " or cab_power_status = 'I03' or cab_power_status = 'I05' )",
			nativeQuery = true)
	public Optional<ArrayList<Armario>> obtenerArmariosConPortOTelEnFalla();
	
	/**
	 * Query para obtener la lista de los armarios activos con puerta entre abierta o abierta
	 * @return
	 */
	@Query(value = "select * from iot_cabinet "
			+ "	where cab_status = 'E22' "
			+ "	and (cab_door_status = 'E11' or cab_door_status = 'E05'"
			+ " or cab_door_status = 'E06')", nativeQuery = true)
	public Optional<ArrayList<Armario>> obtenerArmariosConPuertaEntrAbierta();
	
}
