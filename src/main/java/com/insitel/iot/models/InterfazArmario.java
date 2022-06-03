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
@Table(name = "iot_iar")
public class InterfazArmario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iar_id", unique = true, nullable = false)
	private Long id;

	@JoinColumn(name = "iar_mcr_id", referencedColumnName = "mcr_id")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private MasterControlRegional masterControlRegional;
	
	@Column(name = "iar_name", length = 100)
	private String nombre;
	
	@Column(name = "iar_address", length = 200)
	private String direccion;
	
	@Column(name = "iar_lat")
	private double latitud;
	
	@Column(name = "iar_long", nullable = true)
	private double longitud;
	
	@JoinColumn(name = "iar_com_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Referencia estadoPuerto;
	
	@JoinColumn(name = "iar_status", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Referencia estado;
	
	@Column(name = "iar_com_port", length = 5)
	private String puertoCom;
	
	@JoinColumn(name = "iar_type_8_16", referencedColumnName = "ref_code")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Referencia tipo_8_16;
	
	@Column(name = "iar_carrier_0", length = 20)
	private String carrier_0;
	
	@Column(name = "iar_carrier_1", length = 20)
	private String carrier_1;
	
	@Column(name = "iar_carrier_2", length = 20)
	private String carrier_2;
	
	@Column(name = "iar_carrier_3", length = 20)
	private String carrier_3;
	
	@Column(name = "iar_carrier_4", length = 20)
	private String carrier_4;
	
	@Column(name = "iar_carrier_5", length = 20)
	private String carrier_5;
	
	@Column(name = "iar_carrier_6", length = 20)
	private String carrier_6;
	
	@Column(name = "iar_carrier_7", length = 20)
	private String carrier_7;
	
	@Column(name = "iar_carrier_8", length = 20)
	private String carrier_8;
	
	@Column(name = "iar_carrier_9", length = 20)
	private String carrier_9;
	
	@Column(name = "iar_carrier_10", length = 20)
	private String carrier_10;
	
	@Column(name = "iar_carrier_11", length = 20)
	private String carrier_11;
	
	@Column(name = "iar_carrier_12", length = 20)
	private String carrier_12;
	
	@Column(name = "iar_carrier_13", length = 20)
	private String carrier_13;
	
	@Column(name = "iar_carrier_14", length = 20)
	private String carrier_14;
	
	@Column(name = "iar_carrier_15", length = 20)
	private String carrier_15;

	@Column(name = "iar_tel_0", length = 20)
	private String telefono_0;

	@Column(name = "iar_tel_1", length = 20)
	private String telefono_1;

	@Column(name = "iar_tel_2", length = 20)
	private String telefono_2;
	
	@Column(name = "iar_tel_3", length = 20)
	private String telefono_3;
	
	@Column(name = "iar_tel_4", length = 20)
	private String telefono_4;
	
	@Column(name = "iar_tel_5", length = 20)
	private String telefono_5;
	
	@Column(name = "iar_tel_6", length = 20)
	private String telefono_6;
	
	@Column(name = "iar_tel_7", length = 20)
	private String telefono_7;
	
	@Column(name = "iar_tel_8", length = 20)
	private String telefono_8;
	
	@Column(name = "iar_tel_9", length = 20)
	private String telefono_9;
	
	@Column(name = "iar_tel_10", length = 20)
	private String telefono_10;
	
	@Column(name = "iar_tel_11", length = 20)
	private String telefono_11;
	
	@Column(name = "iar_tel_12", length = 20)
	private String telefono_12;
	
	@Column(name = "iar_tel_13", length = 20)
	private String telefono_13;
	
	@Column(name = "iar_tel_14", length = 20)
	private String telefono_14;
	
	@Column(name = "iar_tel_15", length = 20)
	private String telefono_15;
	
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Referencia getEstadoPuerto() {
		return estadoPuerto;
	}

	public Referencia getEstado() {
		return estado;
	}

	public void setEstado(Referencia estado) {
		this.estado = estado;
	}

	public String getPuertoCom() {
		return puertoCom;
	}

	public Referencia getTipo_8_16() {
		return tipo_8_16;
	}

	public String getCarrier_0() {
		return carrier_0;
	}

	public String getCarrier_1() {
		return carrier_1;
	}

	public String getCarrier_2() {
		return carrier_2;
	}

	public String getCarrier_3() {
		return carrier_3;
	}

	public String getCarrier_4() {
		return carrier_4;
	}

	public String getCarrier_5() {
		return carrier_5;
	}

	public String getCarrier_6() {
		return carrier_6;
	}

	public String getCarrier_7() {
		return carrier_7;
	}

	public String getCarrier_8() {
		return carrier_8;
	}

	public String getCarrier_9() {
		return carrier_9;
	}

	public String getCarrier_10() {
		return carrier_10;
	}

	public String getCarrier_11() {
		return carrier_11;
	}

	public String getCarrier_12() {
		return carrier_12;
	}

	public String getCarrier_13() {
		return carrier_13;
	}

	public String getCarrier_14() {
		return carrier_14;
	}

	public String getCarrier_15() {
		return carrier_15;
	}

	public String getTelefono_0() {
		return telefono_0;
	}

	public String getTelefono_1() {
		return telefono_1;
	}

	public String getTelefono_2() {
		return telefono_2;
	}

	public String getTelefono_3() {
		return telefono_3;
	}

	public String getTelefono_4() {
		return telefono_4;
	}

	public String getTelefono_5() {
		return telefono_5;
	}

	public String getTelefono_6() {
		return telefono_6;
	}

	public String getTelefono_7() {
		return telefono_7;
	}

	public String getTelefono_8() {
		return telefono_8;
	}

	public String getTelefono_9() {
		return telefono_9;
	}

	public String getTelefono_10() {
		return telefono_10;
	}

	public String getTelefono_11() {
		return telefono_11;
	}

	public String getTelefono_12() {
		return telefono_12;
	}

	public String getTelefono_13() {
		return telefono_13;
	}

	public String getTelefono_14() {
		return telefono_14;
	}

	public String getTelefono_15() {
		return telefono_15;
	}

	@Override
	public String toString() {
		return "InterfazArmario [id=" + id + ", masterControlRegional=" + masterControlRegional + ", nombre=" + nombre
				+ ", direccion=" + direccion + ", latitud=" + latitud + ", longitud=" + longitud + ", estadoPuerto="
				+ estadoPuerto + ", estado=" + estado + ", puertoCom=" + puertoCom + ", tipo_8_16=" + tipo_8_16
				+ ", carrier_0=" + carrier_0 + ", carrier_1=" + carrier_1 + ", carrier_2=" + carrier_2 + ", carrier_3="
				+ carrier_3 + ", carrier_4=" + carrier_4 + ", carrier_5=" + carrier_5 + ", carrier_6=" + carrier_6
				+ ", carrier_7=" + carrier_7 + ", carrier_8=" + carrier_8 + ", carrier_9=" + carrier_9 + ", carrier_10="
				+ carrier_10 + ", carrier_11=" + carrier_11 + ", carrier_12=" + carrier_12 + ", carrier_13="
				+ carrier_13 + ", carrier_14=" + carrier_14 + ", carrier_15=" + carrier_15 + ", telefono_0="
				+ telefono_0 + ", telefono_1=" + telefono_1 + ", telefono_2=" + telefono_2 + ", telefono_3="
				+ telefono_3 + ", telefono_4=" + telefono_4 + ", telefono_5=" + telefono_5 + ", telefono_6="
				+ telefono_6 + ", telefono_7=" + telefono_7 + ", telefono_8=" + telefono_8 + ", telefono_9="
				+ telefono_9 + ", telefono_10=" + telefono_10 + ", telefono_11=" + telefono_11 + ", telefono_12="
				+ telefono_12 + ", telefono_13=" + telefono_13 + ", telefono_14=" + telefono_14 + ", telefono_15="
				+ telefono_15 + "]";
	}
	
}
