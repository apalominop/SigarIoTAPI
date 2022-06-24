/**
 * 
 */
package com.insitel.iot.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.Usuario;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	/**
	 * Query para obtener todos los usuarios activos
	 * @return
	 */
	@Query(value = "select u from Usuario u where u.estado = 'UT1' ")
	public ArrayList<Usuario> obtenerUsersActivos();
	
}
