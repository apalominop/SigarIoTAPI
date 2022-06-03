/**
 * 
 */
package com.insitel.iot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cnt_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "cnt_code", length = 3)
	private String codigo;
	
	@Column(name = "cnt_name", length = 50)
	private String nombre;

	//**Getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
