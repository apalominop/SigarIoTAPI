/**
 * 
 */
package com.insitel.iot.models;

import java.io.Serializable;
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
@Table(name = "iot_key")
public class Llave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "key_id")
	private long id;
	
	@Column(name = "key_status", length = 3)
	private String estado;
	
	@Column(name = "key_type", length = 3)
	private String tipo;
	
	@Column(name = "key_cmp_id")
	private long compania;
	
	@Column(name = "key_created_at")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaCreacion;
	
	@Column(name = "key_code", length = 20)
	private String codigo;
	
	//**Getters y setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getCompania() {
		return compania;
	}

	public void setCompania(long compania) {
		this.compania = compania;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Llave [id=" + id + ", estado=" + estado + ", tipo=" + tipo + ", compania=" + compania
				+ ", fechaCreacion=" + fechaCreacion + ", codigo=" + codigo + "]";
	}
	
}
