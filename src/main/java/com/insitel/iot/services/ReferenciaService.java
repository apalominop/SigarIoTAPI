/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.Referencia;
import com.insitel.iot.repositories.ReferenciaRepository;



/**
 * @author Agustín Palomino Pardo
 *
 */

@Service
public class ReferenciaService {
	
	@Autowired
	ReferenciaRepository referenciaRepository;

	/**
	 * Método para obtener todas las referencias hijas de un padre 
	 * @param cod
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Referencia> obtenerHijos(String cod) throws Exception {
		return referenciaRepository.findByRefRefCodigo(cod);
	}

}
