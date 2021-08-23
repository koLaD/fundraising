package com.fundraising.util;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.fundraising.entity.FundraisingProject;
import com.fundraising.util.common.CommonConstant;
import com.fundraising.util.common.CommonUtil;

public class FundraisingProjectDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4653233260522873985L;
	private Long id;
	private String title;
	private String shortDescription;
	private String description;
	private String goalAmount;
	private String image;
	private String createdDate;
	private String updatedDate;
	private Long createdUserId;
	private Long updatedUserId;
	private String projectStatus;
	private MultipartFile projectImageFile;
	private Integer pageNo;
	private String basePath;
	private Long categoryId;

	public FundraisingProjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FundraisingProjectDTO(FundraisingProject fundraisingProject) {
		this.id = fundraisingProject.getId();
		this.title = fundraisingProject.getTitle();
		this.shortDescription = fundraisingProject.getShortDescription();
		this.description = fundraisingProject.getDescription();
		this.goalAmount = fundraisingProject.getGoalAmount();
		this.image = fundraisingProject.getImage();
		this.createdDate = CommonUtil.changeDateToString(CommonConstant.STD_DATE_TIME_FORMAT,
				fundraisingProject.getCreatedDate());
		this.updatedDate = CommonUtil.changeDateToString(CommonConstant.STD_DATE_TIME_FORMAT,
				fundraisingProject.getUpdatedDate());
		this.createdUserId = fundraisingProject.getCreatedUserId();
		this.updatedUserId = fundraisingProject.getUpdatedUserId();
		this.projectStatus = fundraisingProject.getProjectStatus();
	}

	public FundraisingProjectDTO(FundraisingProject fundraisingProject, String basePath) {
		this.id = fundraisingProject.getId();
		this.title = fundraisingProject.getTitle();
		this.shortDescription = fundraisingProject.getShortDescription();
		this.description = fundraisingProject.getDescription();
		this.goalAmount = fundraisingProject.getGoalAmount();
		this.image = CommonUtil.isValidString(fundraisingProject.getImage()) ? basePath + fundraisingProject.getImage() : "";
		this.createdDate = CommonUtil.changeDateToString(CommonConstant.STD_DATE_TIME_FORMAT,
				fundraisingProject.getCreatedDate());
		this.updatedDate = CommonUtil.changeDateToString(CommonConstant.STD_DATE_TIME_FORMAT,
				fundraisingProject.getUpdatedDate());
		this.createdUserId = fundraisingProject.getCreatedUserId();
		this.updatedUserId = fundraisingProject.getUpdatedUserId();
		this.projectStatus = fundraisingProject.getProjectStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGoalAmount() {
		return goalAmount;
	}

	public void setGoalAmount(String goalAmount) {
		this.goalAmount = goalAmount;
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

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public MultipartFile getProjectImageFile() {
		return projectImageFile;
	}

	public void setProjectImageFile(MultipartFile projectImageFile) {
		this.projectImageFile = projectImageFile;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public FundraisingProject changeToEntity(FundraisingProject fundraisingProject) {
		fundraisingProject.setId(this.id);
		fundraisingProject.setTitle(this.title);
		fundraisingProject.setShortDescription(this.shortDescription);
		fundraisingProject.setDescription(this.description);
		fundraisingProject.setGoalAmount(this.goalAmount);
		fundraisingProject.setProjectStatus(this.projectStatus);
		return fundraisingProject;
	}

}
