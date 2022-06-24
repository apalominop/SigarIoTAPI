/**
 * 
 */
package com.insitel.iot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.insitel.iot.models.LlaveUsuario;

/**
 * @author Agustín Palomino Pardo
 *
 */
public interface LlaveUsuarioRepository extends CrudRepository<LlaveUsuario, Long> {

	/**
	 * Query para obtener las llaves asignadas a usuarios
	 * @return
	 */
	@Query(value = "select distinct kus_key_id as keyU"
			+ "   ,key_code as codLlave"
			+ "   ,cmp_name as empresa"
			+ "	  ,usr_doc_id as documento"
			+ "	  ,usr_name || ' ' || usr_lastname as nombre"
			+ "	  ,usr_cellphone || ', ' || usr_phone as telefonos"
			+ "	  ,dep_name as dpto"
			+ "  from iot_key_user"
			+ "   ,iot_user"
			+ "   ,iot_key"
			+ "	  ,iot_company"
			+ "	  ,iot_department"
			+ "  where kus_key_id = key_id"
			+ "    and kus_usr_id = usr_id"
			+ "    and usr_cmp_id = cmp_id"
			+ "	   and usr_dep_id = dep_id"
			+ "  group by keyU, codLlave, empresa, documento, nombre, telefonos, dpto"
			+ "  order by keyU", nativeQuery = true)
	public List<Object[]> obtenerLlavesPorUsuario();
	
}
