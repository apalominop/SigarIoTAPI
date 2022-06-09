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
@Table(name = "iot_company")
public class Compania {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cmp_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "cmp_code", length = 3)
	private String codigo;
	
	@Column(name = "cmp_name", length = 100)
	private String nombre;
	
	@Column(name = "cmp_cnt_id")
	private Long paisId;
	
	@Column(name = "cmp_address", length = 200)
	private String direccion;
	
	@Column(name = "cmp_lat")
	private double latitud;
	
	@Column(name = "cmp_long")
	private double longitud;
	
	@Column(name = "cmp_companyid", length = 50)
	private String nit;
	
	@Column(name = "cmp_type", length = 3)
	private String tipo;
	
	@Column(name = "cmp_contact", length = 200)
	private String contacto;
	
	@Column(name = "cmp_phone", length = 50)
	private String telefono;
	
	@Column(name = "cmp_email", length = 50)
	private String correo;

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

	public Long getPaisId() {
		return paisId;
	}

	public void setPaisId(Long paisId) {
		this.paisId = paisId;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
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


	@Override
	public String toString() {
		return "Compania [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", paisId=" + paisId
				+ ", direccion=" + direccion + ", latitud=" + latitud + ", longitud=" + longitud + ", nit=" + nit
				+ ", tipo=" + tipo + ", contacto=" + contacto + ", telefono=" + telefono + ", correo=" + correo + "]";
	}

}
