package com.klasnic.pos.model.catalogs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper = true)
public class PPL extends Persona {

	private static final long serialVersionUID = 1L;

	public PPL() {
	}

	@ManyToOne(cascade = CascadeType.ALL)
	private CentroFederal centroFederal;

	@ManyToOne(cascade = CascadeType.ALL)
	private ModuloCentroFederal modulo;

	@Column(length = 10, nullable = false)
	private String dormitorio;

	@Column(length = 11, nullable = false, unique = true)
	private String ciPPL;

	@Column(length = 50, nullable = true)
	private String apodo;

	@Column(nullable = false)
	//@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date fechaIngreso;

	@ManyToOne(cascade = CascadeType.ALL)
	private TipoIngresoPPL tipoIngreso;

	@ManyToOne(cascade = CascadeType.ALL)
	private TipoPerfilPPL tipoPerfil;

	@ManyToOne(cascade = CascadeType.ALL)
	private Banco banco;
	
	@Column(nullable=true)
	private BigDecimal importe;

	@Column(length = 18, nullable = true)
	private String clabe;

	@Column(length = 30, nullable = true, unique = true)
	private String folioExpediente;

	@Lob
	@Column(nullable = true)
	private String notas;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private DatosFiscalesPPL datosFiscales;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ppl_id")
	private List<ReferenciaPPL> referencias = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ProductoPPL",
		joinColumns = { @JoinColumn(name= "ppl_id") },
		inverseJoinColumns = { @JoinColumn(name= "producto_id") }
	)
	private List<Producto> productos = new ArrayList<>();

	public void setReferencias(List<ReferenciaPPL> referencias) {
		this.referencias.clear();
		if (referencias != null) {
			this.referencias.addAll(referencias);
		}
	}

}
