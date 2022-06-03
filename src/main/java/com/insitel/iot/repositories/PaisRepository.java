/**
 * 
 */
package com.insitel.iot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.Pais;

/**
 * @author Agustín Palomino Pardo
 *
 */
@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {

}
