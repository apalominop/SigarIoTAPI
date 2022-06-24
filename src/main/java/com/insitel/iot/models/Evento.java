/**
 * 
 */
package com.insitel.iot.models;

import java.sql.Date;
import java.time.LocalTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Entity
@Table(name = "iot_events")
public class Evento {
	
	@Id
	@Basic(optional = false)
	@Column(name = "eve_id", length = 100)
	private String id;

	@Column(name = "eve_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@Column(name = "eve_date_estim")
	private boolean fechaEstimada;
	
	@Column(name = "eve_hour")
	@JsonFormat(pattern = "HH:mm:ss.ss")
	private LocalTime hora;
	
	@Column(name = "eve_cr_id", length = 3)
	private String idCR;
	
	@Column(name = "eve_name", length = 100)
	private String nombre;
	
	@Column(name = "eve_cab_num", length = 3)
	private String numeroArmario;
	
	@Column(name = "eve_ia_num", length = 3)
	private String numeroIA;
	
	@Column(name = "eve_send_sc")
	private Boolean enviado;

	//**Getters y setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isFechaEstimada() {
		return fechaEstimada;
	}

	public boolean getFechaEstimada() {
		return fechaEstimada;
	}
	
	public void setFechaEstimada(boolean fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getIdCR() {
		return idCR;
	}

	public void setIdCR(String idCR) {
		this.idCR = idCR;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroArmario() {
		return numeroArmario;
	}

	public void setNumeroArmario(String numeroArmario) {
		this.numeroArmario = numeroArmario;
	}

	public String getNumeroIA() {
		return numeroIA;
	}

	public void setNumeroIA(String numeroIA) {
		this.numeroIA = numeroIA;
	}

	public Boolean getEnviado() {
		return enviado;
	}

	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", fecha=" + fecha + ", fechaEstimada=" + fechaEstimada + ", hora=" + hora
				+ ", idCR=" + idCR + ", nombre=" + nombre + ", numeroArmario=" + numeroArmario + ", numeroIA="
				+ numeroIA + ", enviado=" + enviado + "]";
	}
	
}
