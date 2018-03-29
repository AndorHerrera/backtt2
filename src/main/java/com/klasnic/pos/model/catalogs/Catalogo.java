package com.klasnic.pos.model.catalogs;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Jesús Israel
 */
@MappedSuperclass
@Data()
@EqualsAndHashCode(callSuper = true)
public class Catalogo extends Activable {

	private static final long serialVersionUID = 1L;

	@Column(length = 10, nullable = false)
	private String clave;

	@Column(length = 50, nullable = false)
	private String descripcion;
}
