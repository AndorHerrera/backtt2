package com.klasnic.pos.model.catalogs;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class Unidad extends Catalogo {

	private static final long serialVersionUID = 1L;

	public Unidad() {
    }
   
}
