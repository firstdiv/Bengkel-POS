package com.airsystem.pos.bengkel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

/**
 * @author Budi Oktaviyan
 */

@Entity
@Table(name = "tbl_user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	private String username;
	private String password;
	private String nama;

	@OneToOne(mappedBy = "user")
	@ForeignKey(name = "FK_USER")
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}