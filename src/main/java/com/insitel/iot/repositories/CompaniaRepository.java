/**
 * 
 */
package com.insitel.iot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.Compania;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface CompaniaRepository extends CrudRepository<Compania, Long> {

}
