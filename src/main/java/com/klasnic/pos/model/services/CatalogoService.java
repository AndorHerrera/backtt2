package com.klasnic.pos.model.services;

import com.klasnic.pos.model.catalogs.Catalogo;
import com.klasnic.pos.model.repositories.CatalogoRepository;

public interface CatalogoService<PO extends Catalogo> extends ActivableService<CatalogoRepository<PO>, PO> {

	PO findByClave(String clave);
}
