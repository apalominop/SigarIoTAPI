/**
 * 
 */
package com.insitel.iot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.LlaveMaestraCR;

/**
 * @author Agustín Palomino Pardo
 *
 */
@Repository
public interface LlaveMaestraCRRepository extends CrudRepository<LlaveMaestraCR, Long> {

}
