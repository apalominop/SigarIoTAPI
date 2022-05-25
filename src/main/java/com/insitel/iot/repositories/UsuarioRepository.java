/**
 * 
 */
package com.insitel.iot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.Usuario;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
}
