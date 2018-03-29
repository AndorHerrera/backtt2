package com.klasnic.pos.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.TipoIngresoPPL;
import com.klasnic.pos.model.repositories.TipoIngresoPPLRepository;

@Service
public class TipoIngresoPPLService extends CatalogoServiceBase<TipoIngresoPPL> {
		
	@Autowired
	public TipoIngresoPPLService(final TipoIngresoPPLRepository repository) {
		super(repository);
	}
}
