package com.klasnic.pos.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Unidad;
import com.klasnic.pos.model.repositories.UnidadRepository;

@Service
public class UnidadService extends CatalogoServiceBase<Unidad> {
		
	@Autowired
	public UnidadService(final UnidadRepository repository) {
		super(repository);
	}
}
