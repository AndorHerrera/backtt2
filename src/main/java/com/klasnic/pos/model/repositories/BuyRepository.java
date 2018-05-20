package com.klasnic.pos.model.repositories;

import java.util.List;

import com.klasnic.pos.model.catalogs.Buy;

public interface BuyRepository extends ActivableRepository<Buy> {
	
	List<Buy> findByUser_Sub(String id);

	List<Buy> findByProyectId(String id);

}
