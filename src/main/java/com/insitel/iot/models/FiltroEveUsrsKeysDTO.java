/**
 * 
 */
package com.insitel.iot.models;

import java.sql.Date;
import java.time.LocalTime;

/**
 * @author Agustín Palomino Pardo
 *
 */
public class FiltroEveUsrsKeysDTO {
	
	private Date fechaInicio;
	private Date fechaFin;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private String documentoUser;
	private String codKey;
	private String cod;
	
	//***Constructors
	public FiltroEveUsrsKeysDTO() {
		super();
	}
	
	public FiltroEveUsrsKeysDTO(Date fechaInicio, Date fechaFin) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public FiltroEveUsrsKeysDTO(Date fechaInicio, Date fechaFin, String documentoUser) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.documentoUser = documentoUser;
	}
	
	public FiltroEveUsrsKeysDTO(Date fechaInicio, Date fechaFin, LocalTime horaInicio, LocalTime horaFin,
			String codKey) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.codKey = codKey;
	}

	//***Getters and setters
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalTime getHoraFin() {
		return horaFin;
	}
	public void setHorafin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
	public String getDocumentoUser() {
		return documentoUser;
	}

	public void setDocumentoUser(String documentoUser) {
		this.documentoUser = documentoUser;
	}

	public String getCodKey() {
		return codKey;
	}
	public void setCodKey(String codKey) {
		this.codKey = codKey;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	@Override
	public String toString() {
		return "FiltroEveUsrsKeysDTO [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", horaInicio="
				+ horaInicio + ", horaFin=" + horaFin + ", documentoUser=" + documentoUser + ", codKey=" + codKey
				+ ", cod=" + cod + "]";
	}

}
