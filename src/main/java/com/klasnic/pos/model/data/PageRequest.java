package com.klasnic.pos.model.data;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.Data;

@Data
public class PageRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	public PageRequest() {
	}

	int pageNumber;
	int pageSize;

	String sortDirection;
	String sortProperty;

	public Pageable createPageable() {
		Sort sort = null;
		if (sortProperty != null && !sortProperty.isEmpty()) {
			sort = new Sort(Direction.fromStringOrNull(sortDirection), sortProperty);
		}
		Pageable pageable = new org.springframework.data.domain.PageRequest(pageNumber, pageSize, sort);
		return pageable;
	}

}
