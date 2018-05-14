package com.klasnic.pos.model.repositories;

import java.util.List;

import com.klasnic.pos.model.catalogs.Movements;
import com.klasnic.pos.model.catalogs.Proyect;

public interface MovementsRepository extends ActivableRepository<Movements> {
		
	List<Movements> findBySub(String sub);

}
