package com.airsystem.pos.bengkel.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * Database entity contains vehicle brand and type information.
 * </p>
 * <b><u>Column definition</u></b>
 * <br>
 * <li> Brand = Merk
 * <li> Type = Sub Merk
 * 
 * @author Fanny Irawan S (fannyirawans@gmail.com)
 */
@Entity
@Table(name = "tbl_vehicle")
public class Vehicle implements Serializable {
	
	private static final long serialVersionUID = 1160325470870745001L;

	@Id
	private String 	brand;
	
	@Id
	private String 	type;
	
	
	// ======================
	// Setter Getter
	// ======================
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
