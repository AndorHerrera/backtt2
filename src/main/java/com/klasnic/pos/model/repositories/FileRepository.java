package com.klasnic.pos.model.repositories;

import java.util.List;

import com.klasnic.pos.model.catalogs.File;

public interface FileRepository extends ActivableRepository<File> {
	
	List<File> findByIdFolder(String id);
		
}
