/**
 * 
 */
package com.insitel.iot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Entity
@Table(name = "iot_key_user")
public class LlaveUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kus_id", unique = true, nullable = false)
	private Long id;
	
	@JoinColumn(name = "kus_key_id", referencedColumnName = "key_id")
	@ManyToOne
	private Llave llave;
	
	@JoinColumn(name = "kus_usr_id", referencedColumnName = "usr_id")
	@ManyToOne
	private Usuario usuario;
	
	//**Getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Llave getLlave() {
		return llave;
	}

	public void setLlave(Llave llave) {
		this.llave = llave;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "LlsveUsuario [id=" + id + ", llave=" + llave + ", usuario=" + usuario + "]";
	}
	
}
