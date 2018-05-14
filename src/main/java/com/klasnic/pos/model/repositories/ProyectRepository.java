package com.klasnic.pos.model.repositories;

import java.util.List;

import com.klasnic.pos.model.catalogs.Proyect;

public interface ProyectRepository extends ActivableRepository<Proyect> {
		
	List<Proyect> findByIdUser(String idUser);
	
	List<Proyect> findByStatus(String status);

	List<Proyect> findAllByUsers_Id(String idUser);

}
