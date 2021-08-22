package com.fundraising.util.common;

public class FieldError {

	private String fieldCode;

	private String errorMessage;

	public enum FieldCode {
		ITEM_CODE("IT1000"), ITEM_NAME("IT1001"), ITEM_LINK("IT1002"), ITEM_ORIGINAL_PRICE("IT1003"),
		ITEM_SELL_PRICE("IT1004"),ITEM_IMAGE_LIST("IT1005");;

		private String code;

		public String getCode() {
			return code;
		}

		private FieldCode(String code) {
			this.code = code;
		}
	}

	public enum ErrorMessage {

		ITEM_CODE_REQUIRED("Item Code is required"), ITEM_NAME_REQUIRED("Item Name is required"),
		ITEM_LINK_REQUIRED("Item Link is required"), ITEM_ORIGINAL_PRICE_REQUIRED("Item Original Price is required"),
		ITEM_SELL_PRICE_REQUIRED("Item Sell Price is required"),ITEM_IMAGE_LIST_REQUIRED("Item Image List is required");

		private String message;

		public String getMessage() {
			return message;
		}

		private ErrorMessage(String message) {
			this.message = message;
		}
	}

	public String getFieldCode() {
		return fieldCode;
	}

	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}