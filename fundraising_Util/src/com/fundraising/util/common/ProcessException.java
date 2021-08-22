package com.fundraising.util.common;

import java.util.List;

public class ProcessException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1285490086792109603L;

	private ErrorType errorType;

	private List<FieldError> fieldErrorList;

	public ProcessException(ErrorType errorType) {
		super(errorType.getDescription());
		this.setErrorType(errorType);
	}

	public enum ErrorType {
		GENERAL("-1", "General application exception occurred while processing user request."),
		LOGIN_FAIL("-1", "Username or Password is incorrect."), INVALID_DATA("-1", "Invalid Data"),
		MULTIPLE_ERROR("1000", ""), INVALID_SESSION("1001", "Invalid Session!"),
		PHONE_DUPLICATE("1002", "Someone’s already using that Phone No."),
		EMAIL_DUPLICATE("1003", "Someone’s already using that Email"),
		NAME_DUPLICATE("1004", "Someone's already using that name"),
		TITLE_DUPLICATE("1005", "Someone's already using that title"),
		INTERESTED_ITEM_DUPLICATE("1006", "You are already interested these item"),
		C2C_ITEM_DUPLICATE("1007", "Someone's already registered these item.");

		private ErrorType(String iCode, String idescription) {
			code = iCode;
			description = idescription;
		}

		public String getCode() {
			return code;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

		private final String code;
		private String description;

	}

	public ErrorType getErrorType() {
		return errorType;
	}

	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}

	public List<FieldError> getFieldErrorList() {
		return fieldErrorList;
	}

	public void setFieldErrorList(List<FieldError> fieldErrorList) {
		this.fieldErrorList = fieldErrorList;
	}

}
