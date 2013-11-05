package com.airsystem.pos.bengkel.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Budi Oktaviyan
 */

@Entity
@Table(name = "tbl_karyawan")
public class Karyawan {

	@Id
	@GeneratedValue
	private Long id;

	private String nama;

	private BigDecimal gaji;
	private BigDecimal uang_makan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public BigDecimal getGaji() {
		return gaji;
	}

	public void setGaji(BigDecimal gaji) {
		this.gaji = gaji;
	}

	public BigDecimal getUang_makan() {
		return uang_makan;
	}

	public void setUang_makan(BigDecimal uang_makan) {
		this.uang_makan = uang_makan;
	}
}