package com.fundraising.util;

import java.util.ArrayList;
import java.util.List;

import com.fundraising.entity.Menu;
import com.fundraising.entity.SubMenu;
import com.fundraising.util.common.CommonConstant;
import com.fundraising.util.common.CommonUtil;

public class MenuDTO {

	private Long id;
	private String code;
	private String description;
	private Integer orderNo;
	private String createdDate;
	private String updatedDate;
	private Long createdUserId;
	private Long updatedUserId;
	private String image;
	private List<SubMenuDTO> subMenuDTOList;

	public MenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuDTO(Menu menu) {
		this.id = menu.getId();
		this.code = menu.getCode();
		this.description = menu.getDescription();
		this.orderNo = menu.getOrderNo();
		this.createdDate = CommonUtil.changeDateToString(CommonConstant.STD_DATE_TIME_FORMAT, menu.getCreatedDate());
		this.updatedDate = CommonUtil.changeDateToString(CommonConstant.STD_DATE_TIME_FORMAT, menu.getUpdatedDate());
		this.createdUserId = menu.getCreatedUserId();
		this.updatedUserId = menu.getUpdatedUserId();
		this.image = menu.getImage();
		this.subMenuDTOList = changeToDtoList(menu.getSubMenu());
	}

	private List<SubMenuDTO> changeToDtoList(List<SubMenu> subMenuList) {
		List<SubMenuDTO> dtoList = new ArrayList<>();
		if (CommonUtil.isValidList(subMenuList)) {
			for (SubMenu entity : subMenuList) {
				dtoList.add(new SubMenuDTO(entity));
			}
		}
		return dtoList;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<SubMenuDTO> getSubMenuDTOList() {
		return subMenuDTOList;
	}

	public void setSubMenuDTOList(List<SubMenuDTO> subMenuDTOList) {
		this.subMenuDTOList = subMenuDTOList;
	}

}
