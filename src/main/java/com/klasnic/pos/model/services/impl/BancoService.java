package com.klasnic.pos.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Banco;
import com.klasnic.pos.model.repositories.BancoRepository;

@Service
public class BancoService extends CatalogoServiceBase<Banco> {
		
	@Autowired
	public BancoService(final BancoRepository repository) {
		super(repository);
	}
}
