package com.klasnic.pos.model.catalogs;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class Rol extends Activable {
      
	private static final long serialVersionUID = 1L;
	
    public Rol() {
    }
    
    public Rol(String id, String nombre) {
    	this.setId(id);
    	this.setNombre(nombre);
    }
        
	@Column(length = 50, nullable = false)
	String nombre;
	
}
