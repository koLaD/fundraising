package com.fundraising.util;

import com.fundraising.entity.SubMenu;
import com.fundraising.util.common.CommonConstant;
import com.fundraising.util.common.CommonUtil;

public class SubMenuDTO {

	private Long id;
	private String code;
	private String description;
	private Integer orderNo;
	private String createdDate;
	private String updatedDate;
	private Long createdUserId;
	private Long updatedUserId;
	private String url;

	public SubMenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubMenuDTO(SubMenu entity) {
		this.id = entity.getId();
		this.code = entity.getCode();
		this.description = entity.getDescription();
		this.orderNo = entity.getOrderNo();
		this.createdDate = CommonUtil.changeDateToString(CommonConstant.STD_DATE_TIME_FORMAT, entity.getCreatedDate());
		this.updatedDate = CommonUtil.changeDateToString(CommonConstant.STD_DATE_TIME_FORMAT, entity.getUpdatedDate());
		this.createdUserId = entity.getCreatedUserId();
		this.updatedUserId = entity.getUpdatedUserId();
		this.url = entity.getUrl();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
