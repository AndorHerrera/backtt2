package com.klasnic.pos.model.catalogs;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Jesús Israel
 */
@MappedSuperclass
@Data()
@EqualsAndHashCode(callSuper=true)
public class Persona extends Activable {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 100, nullable = false)
	private String nombre;
	
	@Column(length = 50, nullable = false)
	private String apellidoPaterno;
	
	@Column(length = 50, nullable = true)
	private String apellidoMaterno;
	
	@Column(nullable = true)
	//@JsonFormat(pattern="dd/MM/yyyy")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date fechaNacimiento;
	
	@Column(length = 12, nullable = true)
	private String telefono;
	
	@Column(length = 50, nullable = true)
	private String email;
	
	@Column(length = 1, nullable = false)
	private Character sexo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private EstadoCivil estadoCivil;

}
