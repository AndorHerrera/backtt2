package com.klasnic.pos.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.GradoEstudios;
import com.klasnic.pos.model.repositories.GradoEstudiosRepository;

@Service
public class GradoEstudiosService extends CatalogoServiceBase<GradoEstudios> {
		
	@Autowired
	public GradoEstudiosService(final GradoEstudiosRepository repository) {
		super(repository);
	}
}
