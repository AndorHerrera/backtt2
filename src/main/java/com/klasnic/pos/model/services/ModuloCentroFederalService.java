package com.klasnic.pos.model.services;

import java.util.List;

import com.klasnic.pos.model.catalogs.CentroFederal;
import com.klasnic.pos.model.catalogs.ModuloCentroFederal;
import com.klasnic.pos.model.repositories.ModuloCentroFederalRepository;

public interface ModuloCentroFederalService extends ActivableService<ModuloCentroFederalRepository, ModuloCentroFederal> {

	List<ModuloCentroFederal> findByCentroFederal(CentroFederal centroFederal);
	ModuloCentroFederal findByClave(String clave);
}
