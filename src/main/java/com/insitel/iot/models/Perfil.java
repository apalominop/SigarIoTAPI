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
@Table(name = "iot_profile")
public class Perfil {

	@Id
	@Basic(optional = false)
	@Column(name = "pro_id")
	private long id;
	
	@Column(name = "pro_document_type", length = 20)
	private String tipoDocumento;
	
	@Column(name = "pro_document_number", length = 20)
	private String numeroDocumento;
	
	@Column(name = "pro_name", length = 40)
	private String nombre;
	
	@Column(name = "pro_last_name", length = 40)
	private String apellidos;
	
	@Column(name ="pro_cel", length = 20)
	private String celular;
	
	@Column(name ="pro_tel", length = 20)
	private String telefono;
	
	@Column(name ="pro_email", length = 100)
	private String correo;
	
	@Column(name ="pro_rol_id")
	private long rolAcceso;
	
	@Column(name = "pro_status", length = 3)
	private String estado;
	
	@Column(name = "pro_password", length = 40)
	private String contrasena;

	//**Getters y setters
	
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public long getRolAcceso() {
		return rolAcceso;
	}

	public void setRolAcceso(long rolAcceso) {
		this.rolAcceso = rolAcceso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", celular=" + celular + ", telefono=" + telefono
				+ ", correo=" + correo + ", rolAcceso=" + rolAcceso + ", estado=" + estado + ", contrasena="
				+ contrasena + "]";
	}
	
}
