package com.airsystem.pos.bengkel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

/**
 * @author Budi Oktaviyan
 */

@Entity
@Table(name = "tbl_role")
public class Role {

	@Id
	@GeneratedValue
	private Integer id;

	private String role;

	@ManyToOne
	@ForeignKey(name = "FK_USER")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}