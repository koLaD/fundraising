package com.fundraising.util;

import java.io.Serializable;

public class FundReceiverDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5981117915489524031L;

	private String id;
	private String name;
	private String address;
	private String phoneNo;
	private String remark;
	private Double receivedAmount;
	private String certificate;
	private String image;
	private String createdDate;
	private String updatedDate;
	private Long createdUserId;
	private Long updatedUserId;

	public FundReceiverDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FundReceiverDTO(String id, String name, String address, String phoneNo, String remark, Double receivedAmount,
			String certificate, String image, String createdDate, String updatedDate, Long createdUserId, Long updatedUserId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.remark = remark;
		this.receivedAmount = receivedAmount;
		this.certificate = certificate;
		this.image = image;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdUserId = createdUserId;
		this.updatedUserId = updatedUserId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(Double receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
