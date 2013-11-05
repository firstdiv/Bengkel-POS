package com.airsystem.pos.bengkel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Budi Oktaviyan
 */

@Entity
@Table(name = "tbl_kendaraan")
public class Kendaraan {

	@Id
	@GeneratedValue
	private Long id;

	private String merk;
	private String sub_merk;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMerk() {
		return merk;
	}

	public void setMerk(String merk) {
		this.merk = merk;
	}

	public String getSub_merk() {
		return sub_merk;
	}

	public void setSub_merk(String sub_merk) {
		this.sub_merk = sub_merk;
	}
}