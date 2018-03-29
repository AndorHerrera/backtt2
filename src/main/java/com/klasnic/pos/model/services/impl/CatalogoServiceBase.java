package com.klasnic.pos.model.services.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.klasnic.pos.model.catalogs.Catalogo;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.CatalogoRepository;
import com.klasnic.pos.model.services.CatalogoService;

public abstract class CatalogoServiceBase<PO extends Catalogo> extends ActivableServiceBase<CatalogoRepository<PO>, PO>
		implements CatalogoService<PO> {

	protected CatalogoServiceBase(final CatalogoRepository<PO> repository) {
		super(repository);
	}

	@Override
	public PO findByClave(String clave) {
		assertRepository();
		return getRepository().findByClave(clave);
	}
	
	@Override
	public List<PO> findByActivo(boolean activo) {
		assertRepository();
		Sort sort = new Sort(Direction.ASC, "descripcion");
		return getRepository().findByActivo(activo, sort);
	}

	@Override
	protected void validateEntity(PO entity) throws DataException {
		assertRepository();
		if (!getRepository().exists(entity.getId())) {
			PO foundItem = getRepository().findByClave(entity.getClave());

			if (foundItem != null) {
				throw new DataException("Un elemento con clave " + entity.getClave() + " ya existe.");
			}
		}
	}

}
