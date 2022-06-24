/**
 * 
 */
package com.insitel.iot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insitel.iot.models.Armario;
import com.insitel.iot.repositories.ArmarioRepository;


/**
 * @author Agustín Palomino Pardo
 *
 */

@Service
public class ArmarioService {
	
	@Autowired
	ArmarioRepository armarioRepository;
	
	/**
	 * Método para buscar todos los armarios
	 * @return
	 */
	public ArrayList<Armario> obtenerArmarios() throws Exception {
		return (ArrayList<Armario>) armarioRepository.findAll();
	}
	
	/**
	 * Método para guardar y actualizar armario
	 * @param armario
	 * @return
	 * @throws Exception
	 */
	public Armario guardarArmario(Armario armario) throws Exception {
		return armarioRepository.save(armario);
	}
	
	/**
	 * Método para obtener armario por Id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Optional<Armario> obtenerArmarioPorId(Long id) throws Exception {
		return armarioRepository.findById(id);
	}
	
	/**
	 * Método para obtener los estados de todos los armarios del CR
	 * @return
	 * @throws Exception
	 */
	public List<Object[]> obtenerEstadosTodosArmarios() throws Exception {
		return armarioRepository.obtenerEstadosTodosArmarios();
	}
	
	/**
	 * Método para obtener el listado de los armarios activos con Servo en falla
	 * @return
	 * @throws Exception
	 */
	public Optional<ArrayList<Armario>> ObtenerArmariosConServoFalla() throws Exception {
		return armarioRepository.ObtenerArmariosConServoFalla();
	}
	
	/**
	 * Método para obtener los armarios activos con portadora o telealimentación en falla
	 * @return
	 * @throws Exception
	 */
	public Optional<ArrayList<Armario>> obtenerArmariosConPortOTelEnFalla() throws Exception {
		return armarioRepository.obtenerArmariosConPortOTelEnFalla();
	}
	
	/**
	 * Método para obtener los armarios activos con puerta entreabierta
	 * @return
	 * @throws Exception
	 */
	public Optional<ArrayList<Armario>> obtenerArmariosConPuertaEntrAbierta() throws Exception {
		return armarioRepository.obtenerArmariosConPuertaEntrAbierta();
	}

}
