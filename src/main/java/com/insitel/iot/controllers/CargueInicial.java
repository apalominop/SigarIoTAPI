/**
 * 
 */
package com.insitel.iot.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insitel.iot.models.Armario;
import com.insitel.iot.models.Compania;
import com.insitel.iot.models.Departamento;
import com.insitel.iot.models.DiaFestivo;
import com.insitel.iot.models.Grupo;
import com.insitel.iot.models.GrupoUsuario;
import com.insitel.iot.models.InterfazArmario;
import com.insitel.iot.models.Llave;
import com.insitel.iot.models.LlaveMaestraCR;
import com.insitel.iot.models.LlaveUsuario;
import com.insitel.iot.models.MasterControlRegional;
import com.insitel.iot.models.Pais;
import com.insitel.iot.models.Referencia;
import com.insitel.iot.models.User;
import com.insitel.iot.models.Usuario;
import com.insitel.iot.services.ArmarioService;
import com.insitel.iot.services.CompaniaService;
import com.insitel.iot.services.DepartamentoService;
import com.insitel.iot.services.DiaFestivoService;
import com.insitel.iot.services.GrupoService;
import com.insitel.iot.services.GrupoUsuarioService;
import com.insitel.iot.services.InterfazArmarioService;
import com.insitel.iot.services.LlaveMaestraCRService;
import com.insitel.iot.services.LlaveService;
import com.insitel.iot.services.LlaveUsuarioService;
import com.insitel.iot.services.MasterControlRegionalService;
import com.insitel.iot.services.PaisService;
import com.insitel.iot.services.ReferenciaService;
import com.insitel.iot.services.UserService;
import com.insitel.iot.services.UsuarioService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/iot")
public class CargueInicial {
	
	@Autowired
	PaisService paisService;
	
	@Autowired
	MasterControlRegionalService mcrService;
	
	@Autowired
	CompaniaService ciaService;
	
	@Autowired
	DiaFestivoService diaFService;
	
	@Autowired
	DepartamentoService dptoService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ReferenciaService refService;
	
	@Autowired
	InterfazArmarioService iaService;
	
	@Autowired
	ArmarioService cabService;
	
	@Autowired
	GrupoService grupoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	GrupoUsuarioService grUserService;
	
	@Autowired
	LlaveService llaveService;
	
	@Autowired
	LlaveUsuarioService llUserService;
	
	@Autowired
	LlaveMaestraCRService llMasterService;
	
	/**
	 * Servicio para obtener todos los registros de la BD por tablas
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "cargue", method = RequestMethod.GET)
	public ArrayList<Object> cargueInicial() throws Exception {
		
		String lPais = "Paises";
		String lMCR = "MCRs";
		String lCia = "Empresas";
		String lDiaF = "Dias Festivos";
		String lDpto = "Departamentos";
		String lUser = "Usuarios Login";
		String lRef = "Referencias";
		String lIa = "IAs";
		String lCab = "Armarios";
		String lGrupo = "Grupos";
		String lUsuario = "Usuarios";
		String lGrUser = "Grupos de Usuarios";
		String lLlave = "Llaves";
		String lLlUser = "Llave Usuarios";
		String lKMaster = "Llaves Maestras"; 
		
		ArrayList<Object> respuesta = new ArrayList<>();
		
		ArrayList<Pais> paises = paisService.obtenerTodosPaises();
		ArrayList<MasterControlRegional> mcr = mcrService.obtenerTodosMCR();
		ArrayList<Compania> cia = ciaService.obtenerTodasCompanias();
		ArrayList<DiaFestivo> dia = diaFService.obtenerTodos();
		ArrayList<Departamento> dpto = dptoService.obtenerTodosDptos();
		ArrayList<User> user = userService.obtenerTodosUsers();
		ArrayList<Referencia> ref = refService.obtenerTodasReferencias();
		ArrayList<InterfazArmario> ia = iaService.obtenerTodasIas();
		ArrayList<Armario> cab = cabService.obtenerArmarios();
		ArrayList<Grupo> grupo = grupoService.obtenerGrupos();
		ArrayList<Usuario> usuario = usuarioService.obtenerTodosUsuarios();
		ArrayList<GrupoUsuario> gUser = grUserService.obtenerTodosGruposUsrs();
		ArrayList<Llave> llave = llaveService.obtenerTodas();
		ArrayList<LlaveUsuario> llUser = llUserService.obtenerTodasLlavesUser();
		ArrayList<LlaveMaestraCR> kMaster = llMasterService.obtenerTodasMaestras();
		
		respuesta.add(lPais);
		respuesta.add(paises);
		respuesta.add(lMCR);
		respuesta.add(mcr);
		respuesta.add(lCia);
		respuesta.add(cia);
		respuesta.add(lDiaF);
		respuesta.add(dia);
		respuesta.add(lDpto);
		respuesta.add(dpto);
		respuesta.add(lUser);
		respuesta.add(user);
		respuesta.add(lRef);
		respuesta.add(ref);
		respuesta.add(lIa);
		respuesta.add(ia);
		respuesta.add(lCab);
		respuesta.add(cab);
		respuesta.add(lGrupo);
		respuesta.add(grupo);
		respuesta.add(lUsuario);
		respuesta.add(usuario);
		respuesta.add(lGrUser);
		respuesta.add(gUser);
		respuesta.add(lLlave);
		respuesta.add(llave);
		respuesta.add(lLlUser);
		respuesta.add(llUser);
		respuesta.add(lKMaster);
		respuesta.add(kMaster);
		
		return respuesta;
	}

}
