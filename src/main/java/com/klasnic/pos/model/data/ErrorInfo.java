package com.klasnic.pos.model.data;

import lombok.Data;

public @Data class ErrorInfo {

	public ErrorInfo(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public ErrorInfo(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	int errorCode;
	String errorMessage;

}
