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
@Table(name = "iot_ia_events")
public class InterfazArmarioEvento {

	@Id
	@Basic(optional = false)
	@Column(name = "ia_eve_id", length = 100)
	private String id;
	
	@Column(name = "ia_eve_ia_id", length = 3)
	private long interfazArmarioEventoId;
	
	@Column(name = "ia_eve_name", length = 100)
	private String nombreEvento;
	
	@Column(name = "ia_id_cr")
	private long idCR;
	
	@Column(name = "ia_eve_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@Column(name = "ia_eve_time")
	private LocalTime hora;

	//**Getters y setters
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getInterfazArmarioEventoId() {
		return interfazArmarioEventoId;
	}

	public void setInterfazArmarioEventoId(long interfazArmarioEventoId) {
		this.interfazArmarioEventoId = interfazArmarioEventoId;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public long getIdCR() {
		return idCR;
	}

	public void setIdCR(long idCR) {
		this.idCR = idCR;
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

	@Override
	public String toString() {
		return "InterfazArmarioEvento [id=" + id + ", interfazArmarioEventoId=" + interfazArmarioEventoId
				+ ", nombreEvento=" + nombreEvento + ", idCR=" + idCR + ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
}
