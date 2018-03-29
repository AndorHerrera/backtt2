package com.klasnic.pos.model.catalogs;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class DatosFiscalesPPL extends Versionable {
      
	private static final long serialVersionUID = 1L;

	public DatosFiscalesPPL() {
    }
	
	@Column(length = 100, nullable = true)
	String razonSocial;
	
	@Column(length = 14, nullable = true)
	String rfc;
	
	@Column(length = 50, nullable = true)
	String email;
	
	@Column(length = 100, nullable = true)
	String calle;
	
	@Column(length = 50, nullable = true)
	String numExterior;
	
	@Column(length = 50, nullable = true)
	String numInterior;

	@Column(length = 50, nullable = true)
	String colonia;
	
	@Column(length = 100, nullable = true)
	String localidad;

	@Column(length = 50, nullable = true)
	String delegacionMunicipio;
	
	@Column(length = 50, nullable = true)
	String estado;
	
	@Column(length = 50, nullable = true)
	String pais;
	
	@Column(length = 5, nullable = true)
	String codigoPostal;
}
