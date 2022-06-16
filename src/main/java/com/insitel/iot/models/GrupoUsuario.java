/**
 * 
 */
package com.insitel.iot.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Entity
@Table(name = "iot_group_user")
public class GrupoUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gru_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name ="gru_grp_id")
	private Long grupo;
	
	@Column(name ="gru_usr_id")
	private Long usuario;


	//**Getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGrupo() {
		return grupo;
	}

	public void setGrupo(Long grupo) {
		this.grupo = grupo;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "GrupoUsuario [id=" + id + ", grupo=" + grupo + ", usuario=" + usuario + "]";
	}

}
