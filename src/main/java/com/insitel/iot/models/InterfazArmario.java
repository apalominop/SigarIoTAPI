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
@Table(name = "iot_iar")
public class InterfazArmario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iar_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "iar_mcr_id")
	private Long cr;
	
	@Column(name = "iar_name", length = 100)
	private String nom;
	
	@Column(name = "iar_address", length = 200)
	private String dir;
	
	@Column(name = "iar_lat")
	private double lat;
	
	@Column(name = "iar_long", nullable = true)
	private double lon;
	
	@Column(name = "iar_com_status", length = 3)
	private String ePto;
	
	@Column(name = "iar_status", length = 3)
	private String est;
	
	@Column(name = "iar_com_port", length = 5)
	private String ptoCom;
	
	@Column(name = "iar_type_8_16", length = 3)
	private String t_8_16;
	
	@Column(name = "iar_carrier_0", length = 20)
	private String c_0;
	
	@Column(name = "iar_carrier_1", length = 20)
	private String c_1;
	
	@Column(name = "iar_carrier_2", length = 20)
	private String c_2;
	
	@Column(name = "iar_carrier_3", length = 20)
	private String c_3;
	
	@Column(name = "iar_carrier_4", length = 20)
	private String c_4;
	
	@Column(name = "iar_carrier_5", length = 20)
	private String c_5;
	
	@Column(name = "iar_carrier_6", length = 20)
	private String c_6;
	
	@Column(name = "iar_carrier_7", length = 20)
	private String c_7;
	
	@Column(name = "iar_carrier_8", length = 20)
	private String c_8;
	
	@Column(name = "iar_carrier_9", length = 20)
	private String c_9;
	
	@Column(name = "iar_carrier_10", length = 20)
	private String c_10;
	
	@Column(name = "iar_carrier_11", length = 20)
	private String c_11;
	
	@Column(name = "iar_carrier_12", length = 20)
	private String c_12;
	
	@Column(name = "iar_carrier_13", length = 20)
	private String c_13;
	
	@Column(name = "iar_carrier_14", length = 20)
	private String c_14;
	
	@Column(name = "iar_carrier_15", length = 20)
	private String c_15;

	@Column(name = "iar_tel_0", length = 20)
	private String t_0;

	@Column(name = "iar_tel_1", length = 20)
	private String t_1;

	@Column(name = "iar_tel_2", length = 20)
	private String t_2;
	
	@Column(name = "iar_tel_3", length = 20)
	private String t_3;
	
	@Column(name = "iar_tel_4", length = 20)
	private String t_4;
	
	@Column(name = "iar_tel_5", length = 20)
	private String t_5;
	
	@Column(name = "iar_tel_6", length = 20)
	private String t_6;
	
	@Column(name = "iar_tel_7", length = 20)
	private String t_7;
	
	@Column(name = "iar_tel_8", length = 20)
	private String t_8;
	
	@Column(name = "iar_tel_9", length = 20)
	private String t_9;
	
	@Column(name = "iar_tel_10", length = 20)
	private String t_10;
	
	@Column(name = "iar_tel_11", length = 20)
	private String t_11;
	
	@Column(name = "iar_tel_12", length = 20)
	private String t_12;
	
	@Column(name = "iar_tel_13", length = 20)
	private String t_13;
	
	@Column(name = "iar_tel_14", length = 20)
	private String t_14;
	
	@Column(name = "iar_tel_15", length = 20)
	private String t_15;

	
	//**Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCr() {
		return cr;
	}

	public void setCr(Long cr) {
		this.cr = cr;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getePto() {
		return ePto;
	}

	public void setePto(String ePto) {
		this.ePto = ePto;
	}

	public String getEst() {
		return est;
	}

	public void setEst(String est) {
		this.est = est;
	}

	public String getPtoCom() {
		return ptoCom;
	}

	public void setPtoCom(String ptoCom) {
		this.ptoCom = ptoCom;
	}

	public String getT_8_16() {
		return t_8_16;
	}

	public String getC_0() {
		return c_0;
	}

	public String getC_1() {
		return c_1;
	}

	public String getC_2() {
		return c_2;
	}

	public String getC_3() {
		return c_3;
	}

	public String getC_4() {
		return c_4;
	}

	public String getC_5() {
		return c_5;
	}

	public String getC_6() {
		return c_6;
	}

	public String getC_7() {
		return c_7;
	}

	public String getC_8() {
		return c_8;
	}

	public String getC_9() {
		return c_9;
	}

	public String getC_10() {
		return c_10;
	}

	public String getC_11() {
		return c_11;
	}

	public String getC_12() {
		return c_12;
	}

	public String getC_13() {
		return c_13;
	}

	public String getC_14() {
		return c_14;
	}

	public String getC_15() {
		return c_15;
	}

	public String getT_0() {
		return t_0;
	}

	public String getT_1() {
		return t_1;
	}

	public String getT_2() {
		return t_2;
	}

	public String getT_3() {
		return t_3;
	}

	public String getT_4() {
		return t_4;
	}

	public String getT_5() {
		return t_5;
	}

	public String getT_6() {
		return t_6;
	}

	public String getT_7() {
		return t_7;
	}

	public String getT_8() {
		return t_8;
	}

	public String getT_9() {
		return t_9;
	}

	public String getT_10() {
		return t_10;
	}

	public String getT_11() {
		return t_11;
	}

	public String getT_12() {
		return t_12;
	}

	public String getT_13() {
		return t_13;
	}

	public String getT_14() {
		return t_14;
	}

	public String getT_15() {
		return t_15;
	}

	@Override
	public String toString() {
		return "InterfazArmario [id=" + id + ", cr=" + cr + ", nom=" + nom + ", dir=" + dir + ", lat=" + lat + ", lon="
				+ lon + ", ePto=" + ePto + ", est=" + est + ", ptoCom=" + ptoCom + ", t_8_16=" + t_8_16 + ", c_0=" + c_0
				+ ", c_1=" + c_1 + ", c_2=" + c_2 + ", c_3=" + c_3 + ", c_4=" + c_4 + ", c_5=" + c_5 + ", c_6=" + c_6
				+ ", c_7=" + c_7 + ", c_8=" + c_8 + ", c_9=" + c_9 + ", c_10=" + c_10 + ", c_11=" + c_11 + ", c_12="
				+ c_12 + ", c_13=" + c_13 + ", c_14=" + c_14 + ", c_15=" + c_15 + ", t_0=" + t_0 + ", t_1=" + t_1
				+ ", t_2=" + t_2 + ", t_3=" + t_3 + ", t_4=" + t_4 + ", t_5=" + t_5 + ", t_6=" + t_6 + ", t_7=" + t_7
				+ ", t_8=" + t_8 + ", t_9=" + t_9 + ", t_10=" + t_10 + ", t_11=" + t_11 + ", t_12=" + t_12 + ", t_13="
				+ t_13 + ", t_14=" + t_14 + ", t_15=" + t_15 + "]";
	}

}
