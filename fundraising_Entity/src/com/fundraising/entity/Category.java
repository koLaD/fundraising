package com.fundraising.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8819035022054083951L;

	@Column(name = "Name")
	private String name;

	@Column(name = "Descritpion")
	private String descritpion;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}

}
