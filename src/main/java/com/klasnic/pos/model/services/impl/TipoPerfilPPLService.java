package com.klasnic.pos.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.TipoPerfilPPL;
import com.klasnic.pos.model.repositories.TipoPerfilPPLRepository;

@Service
public class TipoPerfilPPLService extends CatalogoServiceBase<TipoPerfilPPL> {
		
	@Autowired
	public TipoPerfilPPLService(final TipoPerfilPPLRepository repository) {
		super(repository);
	}
}
