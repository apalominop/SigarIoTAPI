/**
 * 
 */
package com.insitel.iot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insitel.iot.models.LlaveUsuario;
import com.insitel.iot.models.RespuestaLlavesUserDTO;
import com.insitel.iot.services.LlaveUsuarioService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/iot/llaveusr")
public class LlaveUsuarioController {
	
	@Autowired
	public LlaveUsuarioService llaveUsuarioService;
	
	/**
	 * Servicio para obtener todas las LlaveUsuario
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "obtenertodas", method = RequestMethod.GET)
	public ArrayList<LlaveUsuario> obtenerTodasLlavesUser() throws Exception {
		return llaveUsuarioService.obtenerTodasLlavesUser();
	}

	/**
	 * Servicio para obtener las llaves asignadas a usuarios
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "llaveuser", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<RespuestaLlavesUserDTO>> obtenerLlavesPorUsuario() throws Exception {
		
		List<Object[]> lstLlavesUsers = llaveUsuarioService.obtenerLlavesPorUsuario();
		List<RespuestaLlavesUserDTO> lstList = new ArrayList<>();
		
		for (Object[] objetos : lstLlavesUsers) {
			RespuestaLlavesUserDTO llaves = new RespuestaLlavesUserDTO();
			llaves.setKeyUserId(Long.parseLong(objetos[0].toString()));
			llaves.setCodLllave(objetos[1].toString());
			llaves.setEmpresa(objetos[2].toString());
			llaves.setDocUser(objetos[3].toString());
			llaves.setNombreUser(objetos[4].toString());
			llaves.setTelefonos(objetos[5].toString());
			llaves.setDepartamento(objetos[6].toString());
			lstList.add(llaves);
		}
		if (lstList != null && lstList.size() > 0) {
			return ResponseEntity.ok(new ArrayList<>(lstList));
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
}
