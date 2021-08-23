package com.fundraising.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fundraising_project")
public class FundraisingProject extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5732410944005840036L;

	@Column(name = "Title")
	private String title;
	
	@Column(name = "ShortDescription")
	private String shortDescription;

	@Column(name = "Description")
	private String description;

	@Column(name = "GoalAmount")
	private String goalAmount;

	@Column(name = "Image")
	private String image;

	@Column(name = "Status")
	private String projectStatus;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Category_Id")
	private Category category;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

}
