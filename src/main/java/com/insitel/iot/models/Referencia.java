/**
 * 
 */
package com.insitel.iot.models;

import java.io.Serializable;

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
@Table(name = "iot_reference")
public class Referencia implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ref_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "ref_code", nullable = false, length = 3)
	private String refCodigo;
	
	@Column(name = "ref_name", nullable = false, length = 50)
	private String refNombre;
	
	@Column(name = "ref_description")
	private String refDescripcion;
	
	@Column(name = "ref_value")
	private String refValor;
	
	@Column(name = "ref_ref_code")
	private String refRefCodigo;
	

	public Referencia(Long id, String refCodigo) {
		super();
		this.id = id;
		this.refCodigo = refCodigo;
	}

	public Referencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	//**Getter y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRefCodigo() {
		return refCodigo;
	}

	public void setRefCodigo(String refCodigo) {
		this.refCodigo = refCodigo;
	}

	public String getRefNombre() {
		return refNombre;
	}

	public void setRefNombre(String refNombre) {
		this.refNombre = refNombre;
	}

	public String getRefDescripcion() {
		return refDescripcion;
	}

	public void setRefDescripcion(String refDescripcion) {
		this.refDescripcion = refDescripcion;
	}

	public String getRefValor() {
		return refValor;
	}

	public void setRefValor(String refValor) {
		this.refValor = refValor;
	}

	public String getRefRefCodigo() {
		return refRefCodigo;
	}

	public void setRefRefCodigo(String refRefCodigo) {
		this.refRefCodigo = refRefCodigo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Referencia [id=" + id + ", refCodigo=" + refCodigo + ", refNombre=" + refNombre + ", refDescripcion="
				+ refDescripcion + ", refValor=" + refValor + ", refRefCodigo=" + refRefCodigo + "]";
	}
	
}
