/**
 * 
 */
package com.insitel.iot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.DiaFestivo;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface DiaFestivoRepository extends CrudRepository<DiaFestivo, Long> {

}
