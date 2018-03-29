package com.klasnic.pos.model.services;

import java.util.Date;
import java.util.List;

import com.klasnic.pos.model.catalogs.Versionable;
import com.klasnic.pos.model.repositories.VersionableRepository;

public interface VersionableService<R extends VersionableRepository<PO>, PO extends Versionable>
		extends PersistentService<R, PO> {

	List<PO> findByFechaCreacionGreaterThan(Date date);

}
