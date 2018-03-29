package com.klasnic.pos.model.catalogs;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Permiso extends Activable {
      
	private static final long serialVersionUID = 1L;

	public Permiso() {
    }
        
	@Column(length = 50, nullable = false)
	String nombre;
	
	
    
}
