package com.klasnic.pos.model.services.impl;

import java.util.List;

import com.klasnic.pos.model.catalogs.Activable;
import com.klasnic.pos.model.repositories.ActivableRepository;
import com.klasnic.pos.model.services.VersionableService;

public abstract class ActivableServiceBase<R extends ActivableRepository<PO>, PO extends Activable>
		extends VersionableServiceBase<R, PO> implements VersionableService<R, PO> {

	protected ActivableServiceBase(final R repository) {
		super(repository);
	}

	public List<PO> findByActivo(boolean activo) {
		assertRepository();
		return getRepository().findByActivo(activo, null);
	}


}
