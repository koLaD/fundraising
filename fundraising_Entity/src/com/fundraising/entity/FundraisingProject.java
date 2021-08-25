package com.fundraising.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Double goalAmount;

	@Column(name = "DonatedAmount")
	private Double donatedAmount;

	@Column(name = "Image")
	private String image;

	@Column(name = "Status")
	private String projectStatus;

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

	public Double getGoalAmount() {
		return goalAmount;
	}

	public void setGoalAmount(Double goalAmount) {
		this.goalAmount = goalAmount;
	}

	public Double getDonatedAmount() {
		return donatedAmount;
	}

	public void setDonatedAmount(Double donatedAmount) {
		this.donatedAmount = donatedAmount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

}
