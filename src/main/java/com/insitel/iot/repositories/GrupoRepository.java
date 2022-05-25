/**
 * 
 */
package com.insitel.iot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.Grupo;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface GrupoRepository extends CrudRepository<Grupo, Long> {

}
