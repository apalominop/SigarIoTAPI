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
@Table(name = "iot_group")
public class Grupo {

	@Id
	@Basic(optional = false)
	@Column(name = "grp_id")
	private long id;
	
	@Column(name = "grp_name", length = 20)
	private String nombre;
	
	@Column(name = "grp_accountable", length = 100)
	private String responsable;
	
	@Column(name = "grp_cmp_id")
	private long compania;
	
	@Column(name = "grp_status", length = 3)
	private String estado;
	
	@Column(name = "grp_start_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date inicioFecha;
	
	@Column(name = "grp_end_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date finFecha;
	
	@Column(name = "grp_start_hour", length = 8)
	private String inicioHora;
	
	@Column(name = "grp_end_hour", length = 8)
	private String finHora;
	
	@Column(name = "grp_saturday")
	private boolean sabado;
	
	@Column(name = "grp_sunday")
	private boolean domingo;
	
	@Column(name = "grp_holiday")
	private boolean diaFestivo;
	
	//**Getters y setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public long getCompania() {
		return compania;
	}

	public void setCompania(long compania) {
		this.compania = compania;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getInicioFecha() {
		return inicioFecha;
	}

	public void setInicioFecha(Date inicioFecha) {
		this.inicioFecha = inicioFecha;
	}

	public Date getFinFecha() {
		return finFecha;
	}

	public void setFinFecha(Date finFecha) {
		this.finFecha = finFecha;
	}

	public String getInicioHora() {
		return inicioHora;
	}

	public void setInicioHora(String inicioHora) {
		this.inicioHora = inicioHora;
	}

	public String getFinHora() {
		return finHora;
	}

	public void setFinHora(String finHora) {
		this.finHora = finHora;
	}

	public boolean isSabado() {
		return sabado;
	}

	public void setSabado(boolean sabado) {
		this.sabado = sabado;
	}

	public boolean isDomingo() {
		return domingo;
	}

	public void setDomingo(boolean domingo) {
		this.domingo = domingo;
	}

	public boolean isDiaFestivo() {
		return diaFestivo;
	}

	public void setDiaFestivo(boolean diaFestivo) {
		this.diaFestivo = diaFestivo;
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", nombre=" + nombre + ", responsable=" + responsable + ", compania=" + compania
				+ ", estado=" + estado + ", inicioFecha=" + inicioFecha + ", finFecha=" + finFecha + ", inicioHora="
				+ inicioHora + ", finHora=" + finHora + ", sabado=" + sabado + ", domingo=" + domingo + ", diaFestivo="
				+ diaFestivo + "]";
	}
	
}
