package com.klasnic.pos.model.catalogs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class Producto extends Activable {

	private static final long serialVersionUID = 1L;
    
	public Producto() {
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Linea linea;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Serie serie;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Marca marca;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<PPL> ppls = new ArrayList<>();
		
	@Column(length = 250, nullable = false)
	private String naturaleza;
	
	@Column(length = 50,nullable = false,unique = true)
	private String clave;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = true)
	private String descripcion;
	
	@Column(nullable = false)
	private Short cantidadPresentacion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Unidad unidadMedida;
	
	@Column(length = 6,nullable = false)
	private String tipoCodigoBarras;
	
	@Column(length = 13,nullable = false,unique = true)
	private String codigoBarras;
	
	@Lob
	@Column(nullable = false)
	private byte[] imagen;
	
	@Column(nullable=false)
	private BigDecimal iva;

	@Column(nullable = true)
	private BigDecimal precio;
	
	@Column(nullable = false)
	private BigDecimal ieps;
	
	@Column(length=11,nullable=false)
	private String genero;
	
	@Column(length=10,nullable=true)
	private String ClaveProdServSat;
	
	@Column(length=100,nullable=true)
	private String DescripcionSat;
	
}
