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
public class RespuestaArmAbiertoYUserDTO {

	public RespuestaArmAbiertoYUserDTO() {
		super();
	}
	
	private Long cr;
	private String ia;
	private String cab;
	private String eve;
	private String llave;
	
	private String cedula;
	private String nombre;
	private String eveUser;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaApertura;
	
	@JsonFormat(pattern = "HH:mm:ss.ss")
	private LocalTime horaApertura;

	//****Getters y setters****
	public Long getCr() {
		return cr;
	}

	public void setCr(Long cr) {
		this.cr = cr;
	}

	public String getIa() {
		return ia;
	}

	public void setIa(String ia) {
		this.ia = ia;
	}

	public String getCab() {
		return cab;
	}

	public void setCab(String cab) {
		this.cab = cab;
	}

	public String getEve() {
		return eve;
	}

	public void setEve(String eve) {
		this.eve = eve;
	}

	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public LocalTime getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(LocalTime horaApertura) {
		this.horaApertura = horaApertura;
	}

	public String getEveUser() {
		return eveUser;
	}

	public void setEveUser(String eveUser) {
		this.eveUser = eveUser;
	}

	@Override
	public String toString() {
		return "RespuestaArmAbiertoYUserDTO [cr=" + cr + ", ia=" + ia + ", cab=" + cab + ", eve=" + eve + ", llave="
				+ llave + ", cedula=" + cedula + ", nombre=" + nombre + ", eveUser=" + eveUser + ", fechaApertura="
				+ fechaApertura + ", horaApertura=" + horaApertura + "]";
	}

}
