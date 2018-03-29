package com.klasnic.pos.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.EstadoCivil;
import com.klasnic.pos.model.repositories.EstadoCivilRepository;

@Service
public class EstadoCivilService extends CatalogoServiceBase<EstadoCivil> {
		
	@Autowired
	public EstadoCivilService(final EstadoCivilRepository repository) {
		super(repository);
	}
}
