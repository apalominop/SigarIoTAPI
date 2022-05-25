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
@Table(name = "iot_role")
public class Rol {
	
	@Id
	@Basic(optional = false)
	@Column(name = "rol_id")
	private long id;
	
	@Column(name ="rol_name", length = 40)
	private String nombre; 
	
	@Column(name = "rol_pro_id")
	private long perfil;
	
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

	public long getPerfil() {
		return perfil;
	}

	public void setPerfil(long perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", perfil=" + perfil + "]";
	}
	
}
