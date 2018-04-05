package com.klasnic.pos.model.repositories;

import java.util.List;

import com.klasnic.pos.model.catalogs.Folder;

public interface FolderRepository extends ActivableRepository<Folder> {
	
	List<Folder> findByIdFather(String idFather);

		
}
