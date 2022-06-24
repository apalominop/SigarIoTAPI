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
public class RespuestaEventosDTO {
	
	public RespuestaEventosDTO() {
		super();
	}
	
	private String id;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@JsonFormat(pattern = "HH:mm:ss.ss")
	private LocalTime hora;
	
	private boolean estim;
	private Long cr;
	private String ia;
	private String cab;
	private String eve;
	private boolean sc;
	
	
	//****Getters y setters****
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
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public boolean isEstim() {
		return estim;
	}
	public void setEstim(boolean estim) {
		this.estim = estim;
	}
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
	public boolean isSc() {
		return sc;
	}
	public void setSc(boolean sc) {
		this.sc = sc;
	}
	
	@Override
	public String toString() {
		return "RespuestaEventosDTO [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", estim=" + estim + ", cr="
				+ cr + ", ia=" + ia + ", cab=" + cab + ", eve=" + eve + ", sc=" + sc + "]";
	}
	
}
