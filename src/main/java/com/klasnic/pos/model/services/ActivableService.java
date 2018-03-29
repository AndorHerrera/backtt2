package com.klasnic.pos.model.services;

import java.util.List;

import com.klasnic.pos.model.catalogs.Activable;
import com.klasnic.pos.model.repositories.ActivableRepository;

public interface ActivableService<R extends ActivableRepository<PO>, PO extends Activable> 
	extends VersionableService<R, PO>{

	List<PO> findByActivo(boolean activo);
}
