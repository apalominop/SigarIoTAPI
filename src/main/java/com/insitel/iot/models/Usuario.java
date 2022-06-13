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
@Table(name = "iot_user")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "usr_doc_id", length = 20)
	private String docIdentidad;

	@Column(name = "usr_name", length = 100)
	private String nombre;

	@Column(name = "usr_lastname", length = 100)
	private String apellido;

	@Column(name = "usr_status", length = 3)
	private String estado;

	@Column(name = "usr_phone", length = 20)
	private String telefono;

	@Column(name = "usr_cellphone", length = 20)
	private String celular;

	@Column(name = "usr_type", length = 3)
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "usr_cmp_id", referencedColumnName = "cmp_id")
	private Compania compania;
	
	@JoinColumn(name = "usr_dep_id", referencedColumnName = "dep_id")
	@ManyToOne
    private Departamento departamento;

	@Column(name = "usr_email", length = 100)
	private String correo;
	
	//**Getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocIdentidad() {
		return docIdentidad;
	}

	public void setDocIdentidad(String docIdentidad) {
		this.docIdentidad = docIdentidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", docIdentidad=" + docIdentidad + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", estado=" + estado + ", telefono=" + telefono + ", celular=" + celular + ", tipo=" + tipo
				+ ", compania=" + compania + ", departamento=" + departamento + ", correo=" + correo + "]";
	}
	

}
