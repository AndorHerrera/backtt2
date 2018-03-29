package com.klasnic.pos.model.services;

import java.util.List;

import com.klasnic.pos.model.catalogs.Linea;
import com.klasnic.pos.model.catalogs.Serie;
import com.klasnic.pos.model.repositories.SerieRepository;

public interface SerieService extends ActivableService<SerieRepository, Serie> {

	List<Serie> findByLinea(Linea linea);
}
