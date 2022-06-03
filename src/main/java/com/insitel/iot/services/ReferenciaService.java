/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;

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
	
	/**
	 * Método para obtener todas las referencias
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Referencia> obtenerTodasReferencias() throws Exception {
		return (ArrayList<Referencia>) referenciaRepository.findAll();
	}

}
