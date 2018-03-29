package com.klasnic.pos.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Proyect;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.ProyectRepository;
import com.klasnic.pos.model.services.ProyectService;

@Service
public class ProyectServiceImpl extends ActivableServiceBase<ProyectRepository, Proyect>
		implements ProyectService {

	@Autowired
	protected ProyectServiceImpl(final ProyectRepository repository) {
		super(repository);
	}

	@Override
	public List<Proyect> findByActivo(boolean activo) {
		assertRepository();
		Sort sort = new Sort(Direction.ASC, "title");
		return getRepository().findByActivo(activo, sort);
	}

	@Override
	protected void validateEntity(Proyect entity) throws DataException {
		
	}



}