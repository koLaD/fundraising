package com.fundraising.util;

import java.io.Serializable;

import com.fundraising.entity.Fundraiser;
import com.fundraising.entity.FundraisingProject;
import com.fundraising.util.common.CommonConstant;
import com.fundraising.util.common.CommonUtil;

public class FundraiserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3241257592145967475L;

	private Long id;
	private String name;
	private String phoneNo;
	private String remark;
	private String image;
	private String address;
	private Double amount;
	private String createdDate;
	private String updatedDate;
	private Long createdUserId;
	private Long updatedUserId;
	private FundraisingProjectDTO projectDTO;

	public FundraiserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FundraiserDTO(Fundraiser fundraiser) {
		this.id = fundraiser.getId();
		this.name = fundraiser.getName();
		this.phoneNo = fundraiser.getPhoneNo();
		this.remark = fundraiser.getRemark();
		this.image = fundraiser.getImage();
		this.address = fundraiser.getAddress();
		this.amount = fundraiser.getAmount();
		this.createdDate = CommonUtil.changeDateToString(CommonConstant.STD_DATE_TIME_FORMAT, fundraiser.getCreatedDate());
		this.updatedDate = CommonUtil.changeDateToString(CommonConstant.STD_DATE_TIME_FORMAT, fundraiser.getUpdatedDate());
		this.createdUserId = fundraiser.getCreatedUserId();
		this.updatedUserId = fundraiser.getUpdatedUserId();
		if (fundraiser.getFundraisingProject() != null) {
			this.projectDTO = new FundraisingProjectDTO(fundraiser.getFundraisingProject());
		}
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public FundraisingProjectDTO getProjectDTO() {
		return projectDTO;
	}

	public void setProjectDTO(FundraisingProjectDTO projectDTO) {
		this.projectDTO = projectDTO;
	}

	public Fundraiser changeToEntity(Fundraiser fundraiser) {
		fundraiser.setName(this.name);
		fundraiser.setPhoneNo(this.phoneNo);
		fundraiser.setAmount(this.amount);
		fundraiser.setAddress(this.address);
		fundraiser.setRemark(this.remark);
		FundraisingProject fp = new FundraisingProject();
		fp.setId(this.projectDTO.getId());
		fundraiser.setFundraisingProject(fp);
		return fundraiser;
	}

}
