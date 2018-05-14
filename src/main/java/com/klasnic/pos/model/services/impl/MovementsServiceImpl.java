package com.klasnic.pos.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Movements;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.MovementsRepository;
import com.klasnic.pos.model.services.MovementsService;

@Service
public class MovementsServiceImpl extends ActivableServiceBase<MovementsRepository, Movements>
		implements MovementsService {

	@Autowired
	protected MovementsServiceImpl(final MovementsRepository repository) {
		super(repository);
	}

	@Override
	public List<Movements> findByActivo(boolean activo) {
		assertRepository();
		Sort sort = new Sort(Direction.ASC, "name");
		return getRepository().findByActivo(activo, sort);
	}

	@Override
	protected void validateEntity(Movements entity) throws DataException {
		
	}


}
