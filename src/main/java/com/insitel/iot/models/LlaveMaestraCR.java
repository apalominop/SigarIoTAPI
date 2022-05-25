/**
 * 
 */
package com.insitel.iot.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Agustín Palomino Pardo
 *
 */

@Entity
@Table(name = "iot_masterkey_mcr")
public class LlaveMaestraCR {
	
	@Id
	@Basic(optional = false)
	@Column(name = "mkc_id")
	private long id;

	@Column(name = "mkc_mcr_id")
	private long masterControlRegional;

	@Column(name = "mkc_key_id")
	private long llave;
	
	//**Getters y setters

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMasterControlRegional() {
		return masterControlRegional;
	}

	public void setMasterControlRegional(long masterControlRegional) {
		this.masterControlRegional = masterControlRegional;
	}

	public long getLlave() {
		return llave;
	}

	public void setLlave(long llave) {
		this.llave = llave;
	}

	@Override
	public String toString() {
		return "LlaveMaestraCR [id=" + id + ", masterControlRegional=" + masterControlRegional + ", llave=" + llave
				+ "]";
	}

}
