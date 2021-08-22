package com.fundraising.util;

import java.io.Serializable;

public class FundraiserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3241257592145967475L;

	private Long id;
	private String name;
	private String phoneNo;
	private String email;
	private String image;
	private String address;
	private Double amount;
	private String createdDate;
	private String updatedDate;
	private Long createdUserId;
	private Long updatedUserId;

	public FundraiserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FundraiserDTO(Long id, String name, String phoneNo, String email, String image, String address, Double amount,
			String createdDate, String updatedDate, Long createdUserId, Long updatedUserId) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.image = image;
		this.address = address;
		this.amount = amount;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdUserId = createdUserId;
		this.updatedUserId = updatedUserId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(Long createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Long getUpdatedUserId() {
		return updatedUserId;
	}

	public void setUpdatedUserId(Long updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

}
