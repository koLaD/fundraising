package com.fundraising.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fundraiser")
public class Fundraiser extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5732410944005840036L;

	@Column(name = "Name")
	private String name;

	@Column(name = "PhoneNo")
	private String phoneNo;

	@Column(name = "Email")
	private String email;

	@Column(name = "Image")
	private String image;

	@Column(name = "Address")
	private String address;

	@Column(name = "Amount")
	private Double amount;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FundraisingProject_Id")
	private FundraisingProject fundraisingProject;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public FundraisingProject getFundraisingProject() {
		return fundraisingProject;
	}

	public void setFundraisingProject(FundraisingProject fundraisingProject) {
		this.fundraisingProject = fundraisingProject;
	}

}
