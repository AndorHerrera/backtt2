package com.klasnic.pos.model.catalogs;

import java.math.BigDecimal;

import javax.persistence.*;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class IVA extends Activable {

	private static final long serialVersionUID = 1L;
    
	public IVA() {
	}
	
	@Column(nullable = false,unique = true)
	private BigDecimal porcentaje;
}