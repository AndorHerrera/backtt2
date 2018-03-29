package com.klasnic.pos.model.data;

import java.io.Serializable;

import lombok.Data;

@Data
public class FilterRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	public FilterRequest() {
	}

	String property;
	String matchMode;
}
