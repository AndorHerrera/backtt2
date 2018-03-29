package com.klasnic.pos.model.services;

import java.util.List;

import com.klasnic.pos.model.catalogs.Producto;
import com.klasnic.pos.model.repositories.ProductoRepository;

public interface ProductoService extends ActivableService<ProductoRepository, Producto> {
	
	List<Producto> findByClave(String clave);

	
}