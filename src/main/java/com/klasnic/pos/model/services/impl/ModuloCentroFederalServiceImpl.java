package com.klasnic.pos.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.CentroFederal;
import com.klasnic.pos.model.catalogs.ModuloCentroFederal;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.ModuloCentroFederalRepository;
import com.klasnic.pos.model.services.ModuloCentroFederalService;

@Service
public class ModuloCentroFederalServiceImpl extends ActivableServiceBase<ModuloCentroFederalRepository, ModuloCentroFederal>
		implements ModuloCentroFederalService {

	@Autowired
	public ModuloCentroFederalServiceImpl(final ModuloCentroFederalRepository repository) {
		super(repository);
	}

	@Override
	protected void validateEntity(ModuloCentroFederal entity) throws DataException {
		assertRepository();
		if (!getRepository().exists(entity.getId())) {
			ModuloCentroFederal foundItem = getRepository().findByClave(entity.getClave());

			if (foundItem != null) {
				throw new DataException("Un elemento con clave " + entity.getClave() + " ya existe.");
			}
		}
	}

	@Override
	public List<ModuloCentroFederal> findByCentroFederal(CentroFederal centroFederal) {
		assertRepository();		
		return getRepository().findByCentroFederalAndActivoTrueOrderByDescripcion(centroFederal);
	}
	
	@Override
	public ModuloCentroFederal findByClave(String clave) {
		assertRepository();
		return getRepository().findByClave(clave);
	}

}
