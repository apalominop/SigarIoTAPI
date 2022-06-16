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
@Table(name = "iot_user_event")
public class EventoUsuario {
	
	@Id
	@Basic(optional = false)
	@Column(name = "uev_id", length = 100)
	private String id;

	@Column(name = "uev_doc_id", length = 20)
	private String documento;

	@Column(name = "uev_eve_cod", length = 3)
	private String eventoCodigo;
	
	@Column(name = "uev_key_cod",length = 16)
	private String codigoLlave;
	
	@Column(name = "uev_date_estim")
	private Boolean fechaEstimada;

	@Column(name = "uev_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha;

	@Column(name ="uev_hour")
	@JsonFormat(pattern="HH:mm:ss.ss")
	private LocalTime hora;
	
	@Column(name = "uev_cr_id")
	private Long idCR;

	@Column(name = "uev_cab_num", length = 3)
	private String numeroArmario;
	
	@Column(name = "uev_ia_num", length = 3)
	private String numeroIA;

	
	//****Getters y setters ****
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEventoCodigo() {
		return eventoCodigo;
	}

	public void setEventoCodigo(String eventoCodigo) {
		this.eventoCodigo = eventoCodigo;
	}

	public String getCodigoLlave() {
		return codigoLlave;
	}

	public void setCodigoLlave(String codigoLlave) {
		this.codigoLlave = codigoLlave;
	}

	public Boolean getFechaEstimada() {
		return fechaEstimada;
	}

	public void setFechaEstimada(Boolean fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
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

	public Long getIdCR() {
		return idCR;
	}

	public void setIdCR(Long idCR) {
		this.idCR = idCR;
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

	@Override
	public String toString() {
		return "EventoUsuario [id=" + id + ", documento=" + documento + ", eventoCodigo=" + eventoCodigo
				+ ", codigoLlave=" + codigoLlave + ", fechaEstimada=" + fechaEstimada + ", fecha=" + fecha + ", hora="
				+ hora + ", idCR=" + idCR + ", numeroArmario=" + numeroArmario + ", numeroIA=" + numeroIA + "]";
	}

}
