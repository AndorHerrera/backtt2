package com.klasnic.pos.model.repositories;

import java.util.List;

import com.klasnic.pos.model.catalogs.Producto;

public interface ProductoRepository extends ActivableRepository<Producto> {
	
	List<Producto> findByClaveAndActivoTrueOrderByDescripcion(String clave);

	
}
