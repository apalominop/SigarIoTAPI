/**
 * 
 */
package com.insitel.iot.models;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Entity
@Table(name = "iot_cabinet")
public class Armario {

	@Id
	@Basic(optional = false)
	@Column(name = "cab_id")
	private long id;

	@Column(name = "cab_mcr_id")
	private long masterControlRegional;

	@Column(name = "cab_iar_id")
	private long interfazArmario;

	@Column(name = "cab_created_at")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaCreacion;

	@Column(name = "cab_address", length = 200)
	private String direccion;

	@Column(name = "cab_lat")
	private Double latitud;

	@Column(name = "cab_long")
	private Double longitud;

	@Column(name = "cab_status", length = 3)
	private String estado;

	@Column(name = "cab_port_ia", length = 3)
	private String puertoIA;

	@Column(name = "cab_phis_port", length = 3)
	private String puertoFisico;

	@Column(name = "cab_district", length = 20)
	private String distrito;

	@Column(name = "cab_clock", length = 5)
	private String reloj;

	@Column(name = "cab_door_status", length = 3)
	private String estadoPuerta;

	@Column(name = "cab_battery_status", length = 3)
	private String estadoBateria;

	@Column(name = "cab_reader_status", length = 3)
	private String estadoLectura;

	@Column(name = "cab_servo_status", length = 3)
	private String estadoServomotor;

	@Column(name = "cab_position_status", length = 3)
	private String estadoPosicion;

	@Column(name = "cab_carrier_status", length = 3)
	private String estadoCarrier;

	@Column(name = "cab_power_status", length = 3)
	private String estadoEnergia;

	@Column(name = "cab_activation_status", length = 3)
	private String estadoActivacion;

	@Column(name = "cab_masterkey_status", length = 3)
	private String estadoLlaveMaestra;

	@Column(name = "cab_sleep_rfid_status", length = 3)
	private String estadoRfidDormir;

	@Column(name = "cab_sensor1_status", length = 3)
	private String estadoSensor1;

	@Column(name = "cab_sensor2_status", length = 3)
	private String estadoSensor2;

	@Column(name = "cab_sensor3_status", length = 3)
	private String estadoSensor3;
	
	@Column(name = "cab_sensor4_status", length = 3)
	private String estadoSensor4;

	@Column(name = "cab_number")
	private Long numeroArmario;
	
	//**Getters y setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMasterControlRegional() {
		return masterControlRegional;
	}

	public long getInterfazArmario() {
		return interfazArmario;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPuertoIA() {
		return puertoIA;
	}

	public String getPuertoFisico() {
		return puertoFisico;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getReloj() {
		return reloj;
	}

	public String getEstadoPuerta() {
		return estadoPuerta;
	}

	public String getEstadoBateria() {
		return estadoBateria;
	}

	public String getEstadoLectura() {
		return estadoLectura;
	}

	public String getEstadoServomotor() {
		return estadoServomotor;
	}

	public String getEstadoPosicion() {
		return estadoPosicion;
	}

	public String getEstadoCarrier() {
		return estadoCarrier;
	}

	public String getEstadoEnergia() {
		return estadoEnergia;
	}

	public String getEstadoActivacion() {
		return estadoActivacion;
	}

	public String getEstadoLlaveMaestra() {
		return estadoLlaveMaestra;
	}

	public String getEstadoRfidDormir() {
		return estadoRfidDormir;
	}

	public String getEstadoSensor1() {
		return estadoSensor1;
	}

	public String getEstadoSensor2() {
		return estadoSensor2;
	}

	public String getEstadoSensor3() {
		return estadoSensor3;
	}

	public String getEstadoSensor4() {
		return estadoSensor4;
	}

	public Long getNumeroArmario() {
		return numeroArmario;
	}

	@Override
	public String toString() {
		return "Armario [id=" + id + ", masterControlRegional=" + masterControlRegional + ", interfazArmario="
				+ interfazArmario + ", fechaCreacion=" + fechaCreacion + ", direccion=" + direccion + ", latitud="
				+ latitud + ", longitud=" + longitud + ", estado=" + estado + ", puertoIA=" + puertoIA
				+ ", puertoFisico=" + puertoFisico + ", distrito=" + distrito + ", reloj=" + reloj + ", estadoPuerta="
				+ estadoPuerta + ", estadoBateria=" + estadoBateria + ", estadoLectura=" + estadoLectura
				+ ", estadoServomotor=" + estadoServomotor + ", estadoPosicion=" + estadoPosicion + ", estadoCarrier="
				+ estadoCarrier + ", estadoEnergia=" + estadoEnergia + ", estadoActivacion=" + estadoActivacion
				+ ", estadoLlaveMaestra=" + estadoLlaveMaestra + ", estadoRfidDormir=" + estadoRfidDormir
				+ ", estadoSensor1=" + estadoSensor1 + ", estadoSensor2=" + estadoSensor2 + ", estadoSensor3="
				+ estadoSensor3 + ", estadoSensor4=" + estadoSensor4 + ", numeroArmario=" + numeroArmario + "]";
	}
	
	

}
