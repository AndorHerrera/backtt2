package com.klasnic.pos.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Homework;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.HomeworkRepository;
import com.klasnic.pos.model.services.HomeworkService;

@Service
public class HomeworkServiceImpl extends ActivableServiceBase<HomeworkRepository, Homework>
		implements HomeworkService {

	@Autowired
	protected HomeworkServiceImpl(final HomeworkRepository repository) {
		super(repository);
	}

	@Override
	public List<Homework> findByActivo(boolean activo) {
		assertRepository();
		Sort sort = new Sort(Direction.ASC, "name");
		return getRepository().findByActivo(activo, sort);
	}

	@Override
	protected void validateEntity(Homework entity) throws DataException {
		
	}



}
