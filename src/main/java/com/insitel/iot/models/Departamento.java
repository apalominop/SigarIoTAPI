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
@Table(name = "iot_department") 
public class Departamento {
	
	@Id
	@Basic(optional = false)
	@Column(name = "dep_id")
	private long id;
	
	@Column(name = "dep_name", length = 100)
	private String nombre;
	
	@Column(name = "dep_cmp_id")
	private long compania;

	
	//**Getters y setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(long compania) {
		this.compania = compania;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", compania=" + compania + "]";
	}
	
}
