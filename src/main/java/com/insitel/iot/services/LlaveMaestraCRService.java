/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.LlaveMaestraCR;
import com.insitel.iot.repositories.LlaveMaestraCRRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */
@Service
public class LlaveMaestraCRService {
	
	@Autowired
	LlaveMaestraCRRepository llaveMaestraCRRepository;
	
	/**
	 * Método para obtener todas la llaves MAestras del CR
	 * @return
	 * @throws Exception
	 */
	public ArrayList<LlaveMaestraCR> obtenerTodasMaestras() throws Exception {
		return (ArrayList<LlaveMaestraCR>) llaveMaestraCRRepository.findAll();
	}

}
