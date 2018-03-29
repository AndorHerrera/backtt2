package com.klasnic.pos.model.services;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.data.PersistentObject;
import com.klasnic.pos.model.repositories.PersistentRepository;

public interface PersistentService<R extends PersistentRepository<PO>, PO extends PersistentObject> {

	PO save(PO entity) throws DataException;

	List<PO> save(Iterable<PO> entities) throws DataException;

	PO findOne(String id) throws DataException;

	boolean exists(String id);

	List<PO> findAll();

	List<PO> findAll(Iterable<String> ids);
	
	Page<PO> findAll(Pageable pageable);
	
	Page<PO> findAll(Example<PO> example, Pageable pageable);

	long count();

	void delete(String id);

	void delete(PO entity);

}
