/**
 * 
 */
package com.insitel.iot.models;


import java.sql.Date;

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
@Table(name = "iot_holiday")
public class DiaFestivo {

	@Id
	@Basic(optional = false)
	@Column(name = "hol_id")
	private long id;
	
	@Column(name = "hol_cnt_id")
	private long pais;
	
	@Column(name = "hol_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@Column(name = "hol_description")
	private String descripcion;

	//**Getters y setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPais() {
		return pais;
	}

	public void setPais(long pais) {
		this.pais = pais;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "DiaFestivo [id=" + id + ", pais=" + pais + ", fecha=" + fecha + ", descripcion=" + descripcion + "]";
	}
	
}
