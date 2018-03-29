package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.TipoPerfilPPL;
import com.klasnic.pos.model.services.CatalogoService;

@RestController
@RequestMapping("/services/cat/tipoperfilppl")
@CrossOrigin(origins = "*")
public class TipoPerfilPPLController extends CatalogoController<CatalogoService<TipoPerfilPPL>, TipoPerfilPPL> {

	public TipoPerfilPPLController(CatalogoService<TipoPerfilPPL> service) {
		super(service);
		
	}




}
