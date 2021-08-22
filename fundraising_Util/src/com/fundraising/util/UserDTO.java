package com.fundraising.util;

import com.fundraising.entity.User;
import com.fundraising.util.common.CommonConstant;
import com.fundraising.util.common.CommonUtil;

public class UserDTO {

	private Long id;
	private String loginName;
	private String userName;
	private String phoneNo;
	private String password;
	private Integer userStatus;
	private String createdDate;
	private String updatedDate;
	private Long createdUserId;
	private Long updatedUserId;
	private String image;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(User user) {
		super();
		if (user != null) {
			this.id = user.getId();
			this.userName = user.getUserName();
			this.phoneNo = user.getPhoneNo();
			this.password = user.getPassword();
			this.image = user.getImage();
			this.userStatus = user.getUserStatus() == null ? 0 : user.getUserStatus();
			this.createdDate = CommonUtil.changeDateToString(CommonConstant.STD_DATE_FORMAT_dd_MM_yyyy_hh_mm_ss_a,
					user.getCreatedDate());
			this.updatedDate = CommonUtil.changeDateToString(CommonConstant.STD_DATE_FORMAT_dd_MM_yyyy_hh_mm_ss_a,
					user.getUpdatedDate());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
