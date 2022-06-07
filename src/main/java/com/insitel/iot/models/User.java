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
@Table(name = "iot_user_login")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usrl_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "usrl_name", length = 100)
	private String nombre;
	
	@Column(name = "usrl_password", length = 100)
	private String password;
	
	@Column(name = "usrl_token", length = 200)
	private String token;
	
	@Column(name = "usrl_email", length = 100)
	private String email;
	
	//**Getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", password=" + password + ", token=" + token + ", email="
				+ email + "]";
	}

}
