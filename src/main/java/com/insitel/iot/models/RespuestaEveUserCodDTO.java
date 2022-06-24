/**
 * 
 */
package com.insitel.iot.models;

import java.sql.Date;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Agustín Palomino Pardo
 *
 */
public class RespuestaEveUserCodDTO {
	
	public RespuestaEveUserCodDTO() {
		super();
	}
	
	private String codigoLlave;
	private String IdentUsuario;
	private String nombreUser;
	private String evento;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@JsonFormat(pattern = "HH:mm:ss.ss")
	private LocalTime hora;
	
	private Boolean estimada;
	private String cr;
	private String ia;
	private String armario;
	
	//****Getters y setters****
	public String getCodigoLlave() {
		return codigoLlave;
	}
	public void setCodigoLlave(String codigoLlave) {
		this.codigoLlave = codigoLlave;
	}
	public String getIdentUsuario() {
		return IdentUsuario;
	}
	public void setIdentUsuario(String identUsuario) {
		IdentUsuario = identUsuario;
	}
	public String getNombreUser() {
		return nombreUser;
	}
	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public Boolean getEstimada() {
		return estimada;
	}
	public void setEstimada(Boolean estimada) {
		this.estimada = estimada;
	}
	public String getCr() {
		return cr;
	}
	public void setCr(String cr) {
		this.cr = cr;
	}
	public String getIa() {
		return ia;
	}
	public void setIa(String ia) {
		this.ia = ia;
	}
	public String getArmario() {
		return armario;
	}
	public void setArmario(String armario) {
		this.armario = armario;
	}
	
}
