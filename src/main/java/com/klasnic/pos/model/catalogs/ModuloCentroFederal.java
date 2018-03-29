package com.klasnic.pos.model.catalogs;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class ModuloCentroFederal extends Activable {

	public ModuloCentroFederal() {
	}

	private static final long serialVersionUID = 1L;
     
	@Column(length = 10, nullable = false, unique = true)
	private String clave;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CentroFederal centroFederal;
        		
	@Column(length = 50, nullable = false)
	private String descripcion;
    
}
