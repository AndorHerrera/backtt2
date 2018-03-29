package com.klasnic.pos.model.data;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class RequestInfo<PO extends PersistentObject> implements Serializable {

	private static final long serialVersionUID = 1L;

	public RequestInfo() {
	}
	
	PageRequest pageRequest;
	List<FilterRequest> filters;
	PO filterValues;

}
