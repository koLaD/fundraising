package com.fundraising.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sub_menu")
public class SubMenu extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3963331553918134171L;

	@Column(name = "Code")
	private String code;

	@Column(name = "Description")
	private String description;

	@Column(name = "OrderNo")
	private Integer orderNo;

	@Column(name = "Url")
	private String url;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}