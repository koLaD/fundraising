package com.banbann.api.request;

import java.math.BigDecimal;
import java.util.List;

public class ItemRequest {

	private String itemName;

	private String itemCode;

	private String itemLink;

	private List<String> imageList;

	private BigDecimal sellPrice;

	private BigDecimal originalPrice;

	private Boolean isShoe;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemLink() {
		return itemLink;
	}

	public void setItemLink(String itemLink) {
		this.itemLink = itemLink;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Boolean getIsShoe() {
		return isShoe;
	}

	public void setIsShoe(Boolean isShoe) {
		this.isShoe = isShoe;
	}

}
