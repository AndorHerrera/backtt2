package com.klasnic.pos.model.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.klasnic.pos.model.catalogs.Catalogo;
import com.klasnic.pos.model.services.CatalogoService;

public abstract class CatalogoController<S extends CatalogoService<PO>, PO extends Catalogo>
		extends ActivableController<S, PO> {

	@Autowired
	public CatalogoController(S service) {
		super(service);
	}

}
