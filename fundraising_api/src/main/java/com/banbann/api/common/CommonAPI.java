package com.banbann.api.common;

import java.util.List;

import com.banbann.util.common.FieldError;
import com.banbann.util.common.ProcessException;
import com.banbann.util.common.ProcessException.ErrorType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CommonAPI {
	public void setErrorMessage(String code, String message, List<FieldError> errorList) {
		FieldError fieldError = new FieldError();
		fieldError.setFieldCode(code);
		fieldError.setErrorMessage(message);
		errorList.add(fieldError);
	}
	
	@SuppressWarnings("unchecked")
	public static String formatJsonResponse(@SuppressWarnings("rawtypes") Response response, ProcessException pe) {
		Gson gson = new GsonBuilder().create();
		if (pe != null) {
			response.setResponseCode(pe.getErrorType().getCode());
			if (ErrorType.MULTIPLE_ERROR.getCode().equalsIgnoreCase(pe.getErrorType().getCode())) {
				response.setErrorList(pe.getFieldErrorList());
			}
			response.setResponseMessage(pe.getMessage());
		}
		return gson.toJson(response);
	}
}
