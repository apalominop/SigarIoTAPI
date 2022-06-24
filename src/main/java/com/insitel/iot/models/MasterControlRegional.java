/**
 * 
 */
package com.insitel.iot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author JAgustín Palomino Pardo
 *
 */

@Entity
@Table(name = "iot_mcr")
public class MasterControlRegional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mcr_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "mcr_name", length = 100)
	private String nombre;
	
	@Column(name = "mcr_created_at")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaCreacion;
	
	@Column(name = "mcr_status", length = 3)
	private String estado;
	
	@Column(name = "mcr_address", length = 200)
	private String direccion;
	
	@Column(name = "mcr_lat")
	private double latitud;	
	
	@Column(name = "mcr_long")
	private double longitud;
	
	@Column(name = "mcr_com_status", length = 10)
	private String estadoPuerto;
	
	@Column(name = "mcr_ip_address", length = 100)
	private String direccionIP;
	
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getEstadoPuerto() {
		return estadoPuerto;
	}

	public String getDireccionIP() {
		return direccionIP;
	}

	@Override
	public String toString() {
		return "MasterControlRegional [id=" + id + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion
				+ ", estado=" + estado + ", direccion=" + direccion + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", estadoPuerto=" + estadoPuerto + ", direccionIP=" + direccionIP + "]";
	}
	
}
