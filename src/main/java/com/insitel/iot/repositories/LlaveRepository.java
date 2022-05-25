/**
 * 
 */
package com.insitel.iot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.Llave;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface LlaveRepository extends CrudRepository<Llave, Long> {

}
