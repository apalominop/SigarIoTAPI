/**
 * 
 */
package com.insitel.iot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.MasterControlRegional;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface MasterControlRegionalRepository extends CrudRepository<MasterControlRegional, Long> {
	
}
