/**
 * 
 */
package com.insitel.iot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.InterfazArmario;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface InterfazArmarioRepository extends CrudRepository<InterfazArmario, Long> {

	/**
	 * Query para obtener todos los estados las IAs de un CR
	 * @return
	 */
	@Query(value = "select iar_id, iar_com_status, iar_status, iar_carrier_0,"
			+ "    iar_carrier_1, iar_carrier_2, iar_carrier_3, iar_carrier_4,"
			+ "	   iar_carrier_5, iar_carrier_6, iar_carrier_7, iar_carrier_8,"
			+ "	   iar_carrier_9, iar_carrier_10, iar_carrier_11, iar_carrier_12,"
			+ "	   iar_carrier_13, iar_carrier_14, iar_carrier_15, iar_tel_0,"
			+ "	   iar_tel_1, iar_tel_2, iar_tel_3, iar_tel_4, iar_tel_5,"
			+ "	   iar_tel_6, iar_tel_7, iar_tel_8, iar_tel_9, iar_tel_10,"
			+ "	   iar_tel_11, iar_tel_12, iar_tel_13, iar_tel_14, iar_tel_15"
			+ "	   from iot_iar order by iar_id", nativeQuery = true)
	public List<Object[]> obtenerEstadosTodasIas();
	
}
