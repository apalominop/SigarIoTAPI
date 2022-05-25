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
@Table(name = "iot_key_user")
public class LlaveUsuario {

	@Id
	@Basic(optional = false)
	@Column(name = "kus_id")
	private long id;
	
	@Column(name = "kus_key_id")
	private long llave;
	
	@Column(name = "kus_usr_id")
	private long usuario;
	
	//**Getters y setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLlave() {
		return llave;
	}

	public void setLlave(long llave) {
		this.llave = llave;
	}

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "LlsveUsuario [id=" + id + ", llave=" + llave + ", usuario=" + usuario + "]";
	}
	
}
