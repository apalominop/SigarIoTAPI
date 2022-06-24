/**
 * 
 */
package com.insitel.iot.models;

import java.sql.Date;
import java.time.LocalTime;

/**
 * @author Agustín Palomino Pardo
 * Modelo de datos para el filtro de búsqueda de eventos de armarios e IAs
 *
 */

public class FiltroEventosDTO {
	
	public FiltroEventosDTO() {
		super();
	}
	
	private Date fechaInicio;
	private Date fechaFin;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private String tipoEvento;
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fehcaInicio) {
		this.fechaInicio = fehcaInicio;
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

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	@Override
	public String toString() {
		return "FiltroEventosDTO [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", horaInicio=" + horaInicio
				+ ", horaFin=" + horaFin + ", tipoEvento=" + tipoEvento + "]";
	}
	
}
