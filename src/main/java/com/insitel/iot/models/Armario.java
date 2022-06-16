/**
 * 
 */
package com.insitel.iot.models;

import java.sql.Date;

import javax.persistence.*;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cab_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "cab_mcr_id", nullable = false)
	private Long cr;

	@Column(name = "cab_iar_id", nullable = false)
	private Long ia;

	@Column(name = "cab_created_at")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaCreacion;

	@Column(name = "cab_address", length = 200)
	private String dir;

	@Column(name = "cab_lat")
	private Double lat;

	@Column(name = "cab_long")
	private Double lon;

	@Column(name = "cab_status", length = 3)
	private String est;

	@Column(name = "cab_port_ia", length = 3)
	private String pIA;

	@Column(name = "cab_phis_port", length = 3)
	private String pFis;

	@Column(name = "cab_district", length = 20)
	private String dist;

	@Column(name = "cab_clock", length = 5)
	private String reloj;

	@Column(name = "cab_door_status", length = 3)
	private String ePta;

	@Column(name = "cab_battery_status", length = 3)
	private String eBat;

	@Column(name = "cab_reader_status", length = 3)
	private String eLect;

	@Column(name = "cab_servo_status", length = 3)
	private String eServomotor;

	@Column(name = "cab_position_status", length = 3)
	private String ePos;

	@Column(name = "cab_carrier_status", length = 3)
	private String eCarrier;

	@Column(name = "cab_power_status", length = 3)
	private String eEnergia;

	@Column(name = "cab_activation_status", length = 3)
	private String eAct;

	@Column(name = "cab_masterkey_status", length = 3)
	private String eKMaster;

	@Column(name = "cab_sleep_rfid_status", length = 3)
	private String eRfidDormir;

	@Column(name = "cab_sensor1_status", length = 3)
	private String eS1;

	@Column(name = "cab_sensor2_status", length = 3)
	private String eS2;

	@Column(name = "cab_sensor3_status", length = 3)
	private String eS3;
	
	@Column(name = "cab_sensor4_status", length = 3)
	private String eS4;

	@Column(name = "cab_number")
	private Long numArm;
	
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

	public Long getIa() {
		return ia;
	}

	public void setIa(Long ia) {
		this.ia = ia;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public String getEst() {
		return est;
	}

	public void setEst(String est) {
		this.est = est;
	}

	public String getpIA() {
		return pIA;
	}

	public void setpIA(String pIA) {
		this.pIA = pIA;
	}

	public String getpFis() {
		return pFis;
	}

	public void setpFisico(String pFis) {
		this.pFis = pFis;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getReloj() {
		return reloj;
	}

	public void setReloj(String reloj) {
		this.reloj = reloj;
	}

	public String getePta() {
		return ePta;
	}

	public String geteBat() {
		return eBat;
	}

	public String geteLect() {
		return eLect;
	}

	public String geteServomotor() {
		return eServomotor;
	}

	public String getePos() {
		return ePos;
	}

	public String geteCarrier() {
		return eCarrier;
	}

	public String geteEnergia() {
		return eEnergia;
	}

	public String geteAct() {
		return eAct;
	}

	public String geteKMaster() {
		return eKMaster;
	}

	public String geteRfidDormir() {
		return eRfidDormir;
	}

	public String geteS1() {
		return eS1;
	}

	public String geteS2() {
		return eS2;
	}

	public String geteS3() {
		return eS3;
	}

	public String geteS4() {
		return eS4;
	}

	public Long getNumArm() {
		return numArm;
	}

	@Override
	public String toString() {
		return "Armario [id=" + id + ", cr=" + cr + ", ia=" + ia + ", fechaCreacion=" + fechaCreacion + ", dir=" + dir
				+ ", lat=" + lat + ", lon=" + lon + ", est=" + est + ", pIA=" + pIA + ", pFisico=" + pFis + ", dist="
				+ dist + ", reloj=" + reloj + ", ePta=" + ePta + ", eBat=" + eBat + ", eLect=" + eLect
				+ ", eServomotor=" + eServomotor + ", ePos=" + ePos + ", eCarrier=" + eCarrier + ", eEnergia="
				+ eEnergia + ", eAct=" + eAct + ", eKMaster=" + eKMaster + ", eRfidDormir=" + eRfidDormir + ", eS1="
				+ eS1 + ", eS2=" + eS2 + ", eS3=" + eS3 + ", eS4=" + eS4 + ", numArm=" + numArm + "]";
	}
	
}
