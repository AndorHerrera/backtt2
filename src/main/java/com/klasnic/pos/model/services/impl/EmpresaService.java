package com.klasnic.pos.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Empresa;
import com.klasnic.pos.model.repositories.EmpresaRepository;

@Service
public class EmpresaService extends CatalogoServiceBase<Empresa> {
		
	@Autowired
	public EmpresaService(final EmpresaRepository repository) {
		super(repository);
	}
}
