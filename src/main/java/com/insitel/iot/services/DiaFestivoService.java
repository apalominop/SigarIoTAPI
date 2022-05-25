/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.DiaFestivo;
import com.insitel.iot.repositories.DiaFestivoRepository;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Service
public class DiaFestivoService {
	
	@Autowired
	DiaFestivoRepository diaFestivoRepository;
	
	/**
	 * Método para obtener todos los dias festivos
	 * @return
	 * @throws Exception
	 */
	public ArrayList<DiaFestivo> obtenerTodos() throws Exception {
		return (ArrayList<DiaFestivo>) diaFestivoRepository.findAll();
	}
	
	/**
	 * Método para guardar y actualizar un Festivo
	 * @param diaFestivo
	 * @return
	 * @throws Exception
	 */
	public DiaFestivo guardar(DiaFestivo diaFestivo) throws Exception {
		return diaFestivoRepository.save(diaFestivo);
	}
	
	/**
	 * Método para obtener un Festico por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Optional<DiaFestivo> obtenerFestivoPorId(Long id) throws Exception {
		return diaFestivoRepository.findById(id);
	}

}
