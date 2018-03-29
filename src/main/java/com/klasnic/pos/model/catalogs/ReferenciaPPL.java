package com.klasnic.pos.model.catalogs;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class ReferenciaPPL extends Persona {
      
	private static final long serialVersionUID = 1L;

	public ReferenciaPPL() {
    }
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Parentesco parentesco;

}
