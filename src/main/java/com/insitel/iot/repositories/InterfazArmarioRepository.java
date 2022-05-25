/**
 * 
 */
package com.insitel.iot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.InterfazArmario;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface InterfazArmarioRepository extends CrudRepository<InterfazArmario, Long> {

	
}
