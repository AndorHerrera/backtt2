package com.klasnic.pos.model.services.impl;

import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Rol;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.RolRepository;
import com.klasnic.pos.model.services.RolService;

@Service
public class RolServiceImpl extends ActivableServiceBase<RolRepository, Rol> 
	implements RolService {

	public RolServiceImpl(RolRepository repository) {
		super(repository);		
	}

	@Override
	protected void validateEntity(Rol entity) throws DataException {
		// TODO Auto-generated method stub
		
	}
}
