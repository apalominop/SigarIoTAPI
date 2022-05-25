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
@Table(name = "iot_group_user")
public class GrupoUsuario {
	
	@Id
	@Basic(optional = false)
	@Column(name = "gru_id")
	private long id;
	
	@Column(name ="gru_grp_id")
	private long grupo;
	
	@Column(name ="gru_usr_id")
	private long usuario;

	//**Getters y setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGrupo() {
		return grupo;
	}

	public void setGrupo(long grupo) {
		this.grupo = grupo;
	}

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "GrupoUsuario [id=" + id + ", grupo=" + grupo + ", usuario=" + usuario + "]";
	}

}
