package com.fundraising.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fund_receiver")
public class FundReceiver extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8819035022054083951L;

	@Column(name = "Name")
	private String name;

	@Column(name = "Address")
	private String address;

	@Column(name = "PhoneNo")
	private String phoneNo;

	@Column(name = "Remark")
	private String remark;

	@Column(name = "ReceivedAmount")
	private Double receivedAmount;

	@Column(name = "Certificate")
	private String certificate;

	@Column(name = "Image")
	private String image;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FundraisingProject_Id")
	private FundraisingProject fundraisingProject;

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

	public FundraisingProject getFundraisingProject() {
		return fundraisingProject;
	}

	public void setFundraisingProject(FundraisingProject fundraisingProject) {
		this.fundraisingProject = fundraisingProject;
	}

}
