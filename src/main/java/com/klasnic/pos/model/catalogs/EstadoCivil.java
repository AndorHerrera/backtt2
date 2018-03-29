package com.klasnic.pos.model.catalogs;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class EstadoCivil extends Catalogo {

	public EstadoCivil() {
	}

	private static final long serialVersionUID = 1L;
      
    
}
