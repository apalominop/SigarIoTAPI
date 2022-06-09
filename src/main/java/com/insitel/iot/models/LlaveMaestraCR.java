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
@Table(name = "iot_masterkey_mcr")
public class LlaveMaestraCR {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mkc_id", unique = true, nullable = false)
	private Long id;

	@JoinColumn(name = "mkc_mcr_id", referencedColumnName = "mcr_id")
	//@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	//@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@ManyToOne
	private MasterControlRegional masterControlRegional;

	@JoinColumn(name = "mkc_key_id", referencedColumnName = "key_id")
	//@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	//@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@ManyToOne
	private Llave llave;
	
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

	public void setMasterControlRegional(MasterControlRegional masterControlRegional) {
		this.masterControlRegional = masterControlRegional;
	}

	public Llave getLlave() {
		return llave;
	}

	public void setLlave(Llave llave) {
		this.llave = llave;
	}

	@Override
	public String toString() {
		return "LlaveMaestraCR [id=" + id + ", masterControlRegional=" + masterControlRegional + ", llave=" + llave
				+ "]";
	}

}
