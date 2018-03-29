package com.klasnic.pos.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Parentesco;
import com.klasnic.pos.model.repositories.ParentescoRepository;

@Service
public class ParentescoService extends CatalogoServiceBase<Parentesco> {
		
	@Autowired
	public ParentescoService(final ParentescoRepository repository) {
		super(repository);
	}
}
