/**
 * 
 */
package com.insitel.iot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.Departamento;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {

}
