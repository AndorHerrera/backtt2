package com.klasnic.pos.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.IVA;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.IVARepository;
import com.klasnic.pos.model.services.IVAService;

@Service
public class IVAServiceImpl extends ActivableServiceBase<IVARepository, IVA>
		implements IVAService {

	@Autowired
	protected IVAServiceImpl(final IVARepository repository) {
		super(repository);
	}

	@Override
	protected void validateEntity(IVA entity) throws DataException {
		assertRepository();
	}

}