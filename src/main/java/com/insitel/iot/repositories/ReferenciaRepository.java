/**
 * 
 */
package com.insitel.iot.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.Referencia;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Repository
public interface ReferenciaRepository extends CrudRepository<Referencia, Long> {

	/**
	 * Query para obtener los hijos de un código de referencia
	 * @param codigoReferencia
	 * @return
	 */
	public abstract ArrayList<Referencia> findByRefRefCodigo(String refRefCodigo);
}
