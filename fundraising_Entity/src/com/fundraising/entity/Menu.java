package com.fundraising.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu extends BaseEntity implements Serializable {

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

	@Column(name = "Image")
	private String image;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "Menu_Id")
	private List<SubMenu> subMenu;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<SubMenu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<SubMenu> subMenu) {
		this.subMenu = subMenu;
	}

}
