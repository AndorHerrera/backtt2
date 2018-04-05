package com.klasnic.pos.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.File;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.FileRepository;
import com.klasnic.pos.model.services.FileService;

@Service
public class FileServiceImpl extends ActivableServiceBase<FileRepository, File>
		implements FileService {

	@Autowired
	protected FileServiceImpl(final FileRepository repository) {
		super(repository);
	}

	@Override
	public List<File> findByActivo(boolean activo) {
		assertRepository();
		Sort sort = new Sort(Direction.ASC, "name");
		return getRepository().findByActivo(activo, sort);
	}

	@Override
	protected void validateEntity(File entity) throws DataException {
		
	}



}
