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
public class Serie extends Activable {

	public Serie() {
	}

	private static final long serialVersionUID = 1L;
     
	@ManyToOne(cascade = CascadeType.ALL)
	private Linea linea;
        		
	@Column(length = 250, nullable = false)
	private String descripcion;
	
    @Column(length = 20, nullable = false, unique=true)
    private String clave;
    
}
