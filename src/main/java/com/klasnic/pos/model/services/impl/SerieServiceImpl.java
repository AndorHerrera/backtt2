package com.klasnic.pos.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Linea;
import com.klasnic.pos.model.catalogs.Serie;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.SerieRepository;
import com.klasnic.pos.model.services.SerieService;

@Service
public class SerieServiceImpl extends ActivableServiceBase<SerieRepository, Serie>
		implements SerieService {

	@Autowired
	public SerieServiceImpl(final SerieRepository repository) {
		super(repository);
	}

	@Override
	protected void validateEntity(Serie entity) throws DataException {
				
	}

	@Override
	public List<Serie> findByLinea(Linea linea) {
		assertRepository();		
		return getRepository().findByLineaAndActivoTrueOrderByDescripcion(linea);
	}
}
