/**
 * 
 */
package com.insitel.iot.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Agustín Palomino Pardo
 *
 */

@Entity
@Table(name = "iot_country") 
public class Pais {
	
	@Id
	@Basic(optional = false)
	@Column(name = "cnt_id")
	private long id;
	
	@Column(name = "cnt_code", length = 3)
	private String codigo;
	
	@Column(name = "cnt_name", length = 50)
	private String nombre;

	//**Getters y setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
}
