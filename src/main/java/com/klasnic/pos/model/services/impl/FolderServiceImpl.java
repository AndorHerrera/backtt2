package com.klasnic.pos.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Folder;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.FolderRepository;
import com.klasnic.pos.model.services.FolderService;

@Service
public class FolderServiceImpl extends ActivableServiceBase<FolderRepository, Folder>
		implements FolderService {

	@Autowired
	protected FolderServiceImpl(final FolderRepository repository) {
		super(repository);
	}

	@Override
	public List<Folder> findByActivo(boolean activo) {
		assertRepository();
		Sort sort = new Sort(Direction.ASC, "name");
		return getRepository().findByActivo(activo, sort);
	}

	@Override
	protected void validateEntity(Folder entity) throws DataException {
		
	}



}
