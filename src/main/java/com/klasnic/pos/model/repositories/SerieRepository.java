package com.klasnic.pos.model.repositories;

import java.util.List;

import com.klasnic.pos.model.catalogs.Linea;
import com.klasnic.pos.model.catalogs.Serie;

public interface SerieRepository extends ActivableRepository<Serie> {
	
	List<Serie> findByLineaAndActivoTrueOrderByDescripcion(Linea linea);
}
