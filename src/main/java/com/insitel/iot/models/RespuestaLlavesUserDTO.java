/**
 * 
 */
package com.insitel.iot.models;

/**
 * @author Agustín Palomino Pardo
 *
 */
public class RespuestaLlavesUserDTO {
	
	public RespuestaLlavesUserDTO() {
		super();
	}
	
	private Long keyUserId;
	private String codLllave;
	private String empresa;
	private String docUser;
	private String nombreUser;
	private String telefonos;
	private String departamento;
	
	
	//**** Getters y setters****
	public Long getKeyUserId() {
		return keyUserId;
	}
	public void setKeyUserId(Long keyUserId) {
		this.keyUserId = keyUserId;
	}
	public String getCodLllave() {
		return codLllave;
	}
	public void setCodLllave(String codLllave) {
		this.codLllave = codLllave;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getDocUser() {
		return docUser;
	}
	public void setDocUser(String docUser) {
		this.docUser = docUser;
	}
	public String getNombreUser() {
		return nombreUser;
	}
	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}
	public String getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
