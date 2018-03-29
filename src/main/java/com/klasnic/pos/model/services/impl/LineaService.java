package com.klasnic.pos.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Linea;
import com.klasnic.pos.model.repositories.LineaRepository;

@Service
public class LineaService extends CatalogoServiceBase<Linea> {
		
	@Autowired
	public LineaService(final LineaRepository repository) {
		super(repository);
	}
}