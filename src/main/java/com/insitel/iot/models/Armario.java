/**
 * 
 */
package com.insitel.iot.models;

import java.sql.Date;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Entity
@Table(name = "iot_cabinet")
public class Armario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cab_id", unique = true, nullable = false)
	private Long id;

	@JoinColumn(name = "cab_mcr_id", referencedColumnName = "mcr_id", nullable = false)
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private MasterControlRegional masterControlRegional;

	@JoinColumn(name = "cab_iar_id", referencedColumnName = "iar_id", nullable = false)
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private InterfazArmario interfazArmario;

	@Column(name = "cab_created_at")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaCreacion;

	@Column(name = "cab_address", length = 200)
	private String direccion;

	@Column(name = "cab_lat")
	private Double latitud;

	@Column(name = "cab_long")
	private Double longitud;

	@JoinColumn(name = "cab_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Referencia estado;

	@Column(name = "cab_port_ia", length = 3)
	private String puertoIA;

	@Column(name = "cab_phis_port", length = 3)
	private String puertoFisico;

	@Column(name = "cab_district", length = 20)
	private String distrito;

	@Column(name = "cab_clock", length = 5)
	private String reloj;

	@JoinColumn(name = "cab_door_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Referencia estadoPuerta;

	@JoinColumn(name = "cab_battery_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Referencia estadoBateria;

	@JoinColumn(name = "cab_reader_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Referencia estadoLectura;

	@JoinColumn(name = "cab_servo_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Referencia estadoServomotor;

	@JoinColumn(name = "cab_position_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	private Referencia estadoPosicion;

	@JoinColumn(name = "cab_carrier_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	private Referencia estadoCarrier;

	@JoinColumn(name = "cab_power_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	private Referencia estadoEnergia;

	@JoinColumn(name = "cab_activation_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Referencia estadoActivacion;

	@JoinColumn(name = "cab_masterkey_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	private Referencia estadoLlaveMaestra;

	@JoinColumn(name = "cab_sleep_rfid_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	private Referencia estadoRfidDormir;

	@JoinColumn(name = "cab_sensor1_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	private Referencia estadoSensor1;

	@JoinColumn(name = "cab_sensor2_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Referencia estadoSensor2;

	@JoinColumn(name = "cab_sensor3_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	private Referencia estadoSensor3;
	
	@JoinColumn(name = "cab_sensor4_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	private Referencia estadoSensor4;

	@Column(name = "cab_number")
	private Long numeroArmario;
	
	//**Getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MasterControlRegional getMasterControlRegional() {
		return masterControlRegional;
	}

	public InterfazArmario getInterfazArmario() {
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

	public Referencia getEstado() {
		return estado;
	}

	public void setEstado(Referencia estado) {
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

	public Referencia getEstadoPuerta() {
		return estadoPuerta;
	}

	public Referencia getEstadoBateria() {
		return estadoBateria;
	}

	public Referencia getEstadoLectura() {
		return estadoLectura;
	}

	public Referencia getEstadoPosicion() {
		return estadoPosicion;
	}

	public Referencia getEstadoCarrier() {
		return estadoCarrier;
	}

	public Referencia getEstadoEnergia() {
		return estadoEnergia;
	}

	public Referencia getEstadoActivacion() {
		return estadoActivacion;
	}

	public Referencia getEstadoLlaveMaestra() {
		return estadoLlaveMaestra;
	}

	public Referencia getEstadoRfidDormir() {
		return estadoRfidDormir;
	}

	public Referencia getEstadoSensor1() {
		return estadoSensor1;
	}

	public Referencia getEstadoSensor2() {
		return estadoSensor2;
	}

	public Referencia getEstadoSensor3() {
		return estadoSensor3;
	}

	public void setEstadoSensor3(Referencia estadoSensor3) {
		this.estadoSensor3 = estadoSensor3;
	}

	public Referencia getEstadoSensor4() {
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
