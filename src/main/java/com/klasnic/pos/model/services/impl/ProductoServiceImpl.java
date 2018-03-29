package com.klasnic.pos.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Producto;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.ProductoRepository;
import com.klasnic.pos.model.services.ProductoService;

@Service
public class ProductoServiceImpl extends ActivableServiceBase<ProductoRepository, Producto>
		implements ProductoService {

	@Autowired
	protected ProductoServiceImpl(final ProductoRepository repository) {
		super(repository);
	}

	@Override
	protected void validateEntity(Producto entity) throws DataException {
		assertRepository();
	}
	
	@Override
	public List<Producto> findByClave(String clave) {
		assertRepository();		
		return getRepository().findByClaveAndActivoTrueOrderByDescripcion(clave);
	}

}