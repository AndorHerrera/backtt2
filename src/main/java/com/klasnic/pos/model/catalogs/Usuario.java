package com.klasnic.pos.model.catalogs;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Persona {

	private static final long serialVersionUID = 1L;

	public Usuario() {
	}

	@Column(length = 8, nullable = false, unique = true)
	private String idUsuario;

	@Column(nullable = false, unique = true)
	private long idUsuarioN;
	
	@Column(length = 350, nullable = true)
	@JsonIgnore
	private String password;

	@ManyToOne(cascade = CascadeType.ALL)
	private CentroFederal centroFederal;

	@ManyToOne(cascade = CascadeType.ALL)
	private GradoEstudios gradoEstudios;

	@ManyToOne(cascade = CascadeType.ALL)
	private TipoContratacion tipoContratacion;

	@ManyToOne(cascade = CascadeType.ALL)
	private Empresa empresa;

	@Lob
	@Column(nullable = true)
	private String notas;

	@ManyToMany(targetEntity = Rol.class)
	private List<Rol> roles;
	
}
