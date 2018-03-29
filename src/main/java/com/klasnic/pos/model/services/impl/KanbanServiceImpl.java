package com.klasnic.pos.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Kanban;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.KanbanRepository;
import com.klasnic.pos.model.services.KanbanService;

@Service
public class KanbanServiceImpl extends ActivableServiceBase<KanbanRepository, Kanban>
		implements KanbanService {

	@Autowired
	protected KanbanServiceImpl(final KanbanRepository repository) {
		super(repository);
	}

	@Override
	public List<Kanban> findByActivo(boolean activo) {
		assertRepository();
		Sort sort = new Sort(Direction.ASC, "name");
		return getRepository().findByActivo(activo, sort);
	}

	@Override
	protected void validateEntity(Kanban entity) throws DataException {
		
	}


}
