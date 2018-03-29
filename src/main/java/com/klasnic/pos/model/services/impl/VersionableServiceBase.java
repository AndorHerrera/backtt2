package com.klasnic.pos.model.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.klasnic.pos.model.catalogs.Versionable;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.VersionableRepository;
import com.klasnic.pos.model.services.VersionableService;

public abstract class VersionableServiceBase<R extends VersionableRepository<PO>, PO extends Versionable>
		implements VersionableService<R, PO> {

	protected VersionableServiceBase(final R repository) {
		this.repository = repository;
	}

	static String ASSERT_REPOSITORY = "Se debe implementar el Repositorio para %s";

	protected void assertRepository() {
		assert getRepository() != null : String.format(ASSERT_REPOSITORY, this.getClass().getName());
	}

	final R repository;

	protected R getRepository() {
		return (R) repository;
	}

	protected abstract void validateEntity(PO entity) throws DataException;

	protected void validateIsNull(Object obj) {
		if (obj == null) {
			throw new DataException();
		}
	}

	protected void updateVersionableData(Versionable entity) {
		if (entity.getFechaCreacion() == null) {
			entity.setFechaCreacion(new Date());
		}

		entity.setFechaModificacion(new Date());
	}

	@Override
	public PO save(PO entity) throws DataException {
		assertRepository();
		updateVersionableData(entity);
		validateEntity(entity);
		return getRepository().save(entity);
	}

	@Override
	public List<PO> save(Iterable<PO> entities) throws DataException {
		assertRepository();
		for (PO entity : entities) {
			updateVersionableData(entity);
			validateEntity(entity);
		}
		return getRepository().save(entities);
	}

	@Override
	public PO findOne(String id) throws DataException {
		assertRepository();
		PO foundItem = getRepository().findOne(id);
		if (foundItem == null) {
			throw new DataException(String.format("Elemento con id '%s' no encontrado.", id));
		}

		return foundItem;
	}

	@Override
	public boolean exists(String id) {
		assertRepository();
		return getRepository().exists(id);
	}

	@Override
	public List<PO> findAll() {
		assertRepository();
		return getRepository().findAll();
	}

	@Override
	public List<PO> findAll(Iterable<String> ids) {
		assertRepository();
		return getRepository().findAll(ids);
	}

	@Override
	public Page<PO> findAll(Pageable pageable) {
		assertRepository();
		return getRepository().findAll(pageable);
	}
	
	@Override
	public Page<PO> findAll(Example<PO> example, Pageable pageable) {
		assertRepository();
		return getRepository().findAll(example, pageable);
	}

	@Override
	public long count() {
		assertRepository();
		return getRepository().count();
	}

	@Override
	public void delete(String id) {
		assertRepository();
		getRepository().delete(id);
	}

	@Override
	public void delete(PO entity) {
		assertRepository();
		getRepository().delete(entity);
	}

	@Override
	public List<PO> findByFechaCreacionGreaterThan(Date date) {
		assertRepository();
		return getRepository().findByFechaCreacionGreaterThan(date);
	}

}
