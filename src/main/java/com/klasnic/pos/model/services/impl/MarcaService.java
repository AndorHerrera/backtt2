package com.klasnic.pos.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Marca;
import com.klasnic.pos.model.repositories.MarcaRepository;

@Service
public class MarcaService extends CatalogoServiceBase<Marca> {
		
	@Autowired
	public MarcaService(final MarcaRepository repository) {
		super(repository);
	}
}