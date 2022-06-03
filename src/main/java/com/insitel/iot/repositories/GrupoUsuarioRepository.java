/**
 * 
 */
package com.insitel.iot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.GrupoUsuario;

/**
 * @author Agustín Palomino Pardo
 *
 */
@Repository
public interface GrupoUsuarioRepository extends CrudRepository<GrupoUsuario, Long> {

}
