package com.klasnic.pos.model.catalogs;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class Tag extends Catalogo {

	public Tag() {
	}

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = true)
	private int i;
      
    
}
