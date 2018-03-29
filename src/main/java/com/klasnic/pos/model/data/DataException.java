package com.klasnic.pos.model.data;

import javax.validation.ValidationException;

public class DataException extends ValidationException {

	private static final long serialVersionUID = 1L;

	public DataException() {
		// TODO Auto-generated constructor stub
	}

	public DataException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DataException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DataException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
