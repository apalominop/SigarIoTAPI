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
	private String est;
	
	@Column(name = "key_type", length = 3)
	private String tipo;
	
	@Column(name = "key_cmp_id")
	private Long comp;
	
	@Column(name = "key_created_at")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fCrea;
	
	@Column(name = "key_code", length = 20)
	private String cod;
	
	//**Getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEst() {
		return est;
	}

	public void setEst(String est) {
		this.est = est;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getComp() {
		return comp;
	}

	public void setComp(Long comp) {
		this.comp = comp;
	}
	
	public Date getfCrea() {
		return fCrea;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	@Override
	public String toString() {
		return "Llave [id=" + id + ", estado=" + est + ", tipo=" + tipo + ", compania=" + comp
				+ ", fechaCreacion=" + fCrea + ", codigo=" + cod + "]";
	}
	
}
