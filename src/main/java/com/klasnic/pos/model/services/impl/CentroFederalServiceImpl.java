package com.klasnic.pos.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.CentroFederal;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.CentroFederalRepository;
import com.klasnic.pos.model.services.CentroFederalService;

@Service
public class CentroFederalServiceImpl extends ActivableServiceBase<CentroFederalRepository, CentroFederal>
		implements CentroFederalService {

	@Autowired
	protected CentroFederalServiceImpl(final CentroFederalRepository repository) {
		super(repository);
	}

	@Override
	public List<CentroFederal> findByActivo(boolean activo) {
		assertRepository();
		Sort sort = new Sort(Direction.ASC, "nombre");
		return getRepository().findByActivo(activo, sort);
	}

	@Override
	protected void validateEntity(CentroFederal entity) throws DataException {
		assertRepository();
		if (!getRepository().exists(entity.getId())) {
			CentroFederal foundItem = getRepository().findByClave(entity.getClave());

			if (foundItem != null) {
				throw new DataException("Un elemento con clave " + entity.getClave() + " ya existe.");
			}
		}
	}

	@Override
	public CentroFederal findByClave(String clave) {
		assertRepository();
		return getRepository().findByClave(clave);
	}


}
