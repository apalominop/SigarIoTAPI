/**
 * 
 */
package com.insitel.iot.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "key_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "key_status", length = 3)
	private String estado;
	
	@Column(name = "key_type", length = 3)
	private String tipo;
	
	@JoinColumn(name = "key_cmp_id", referencedColumnName = "cmp_id")
	@ManyToOne
	private Compania compania;
	
	@Column(name = "key_created_at")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaCreacion;
	
	@Column(name = "key_code", length = 20)
	private String codigo;
	
	//**Getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
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
