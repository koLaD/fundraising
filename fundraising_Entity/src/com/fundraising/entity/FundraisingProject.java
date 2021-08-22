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

	@Column(name = "ShortDescritpion")
	private String shortDescritpion;

	@Column(name = "Descritpion")
	private String descritpion;

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

	public String getShortDescritpion() {
		return shortDescritpion;
	}

	public void setShortDescritpion(String shortDescritpion) {
		this.shortDescritpion = shortDescritpion;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
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
