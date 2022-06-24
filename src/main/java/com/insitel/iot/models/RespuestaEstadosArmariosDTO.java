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
public class RespuestaEstadosArmariosDTO {

	public RespuestaEstadosArmariosDTO() {
		super();
	}
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@JsonFormat(pattern = "HH:mm:ss.ss")
	private LocalTime hora;
	
	private Long cr;
	private String ia;
	private String cab;
	private String eve;
	
	//****Getters y setters****
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
	@Override
	public String toString() {
		return "RespuestaEstadosArmariosDTO [fecha=" + fecha + ", hora=" + hora + ", cr=" + cr + ", ia=" + ia + ", cab="
				+ cab + ", eve=" + eve + "]";
	}
	
}
