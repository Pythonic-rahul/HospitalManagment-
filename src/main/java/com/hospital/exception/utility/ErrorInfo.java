package com.hospital.exception.utility;

public class ErrorInfo {
	private String errorMessage;
	private Integer errorCode;

	public String getErrorMessage() {
		return errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
