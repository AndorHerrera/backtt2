package com.klasnic.pos.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.TipoContratacion;
import com.klasnic.pos.model.repositories.TipoContratacionRepository;

@Service
public class TipoContratacionService extends CatalogoServiceBase<TipoContratacion> {
		
	@Autowired
	public TipoContratacionService(final TipoContratacionRepository repository) {
		super(repository);
	}
}
