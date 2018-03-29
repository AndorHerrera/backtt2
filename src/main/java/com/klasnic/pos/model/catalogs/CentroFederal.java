package com.klasnic.pos.model.catalogs;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class CentroFederal extends Activable {
      
	private static final long serialVersionUID = 1L;

	public CentroFederal() {
    }	
	
	@Column(length = 20, nullable = false, unique = true)
	private String clave;
	
	@Column(length = 100, nullable = false)
    String nombre;
    
	@Column(length = 100, nullable = true)
    String zona;

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
	
	@Column(length = 50, nullable = true)
    String coordenadas;
	
	@Column(length = 12, nullable = true)
    String telefono;
	
	@Column(nullable = false)
	BigDecimal importeMensual;

	@Column(length = 11,nullable = false)
	String genero;
	
	@Column(nullable = true)
    Integer capacidad;
}
