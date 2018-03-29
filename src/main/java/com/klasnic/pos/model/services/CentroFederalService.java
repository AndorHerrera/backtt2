package com.klasnic.pos.model.services;

import com.klasnic.pos.model.catalogs.CentroFederal;
import com.klasnic.pos.model.repositories.CentroFederalRepository;

public interface CentroFederalService extends ActivableService<CentroFederalRepository, CentroFederal> {
	CentroFederal findByClave(String clave);
}
