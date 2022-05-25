/**
 * 
 */
package com.insitel.iot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.Armario;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface ArmarioRepository extends CrudRepository<Armario, Long> {
	
}
