package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.TipoIngresoPPL;
import com.klasnic.pos.model.services.CatalogoService;

@RestController
@RequestMapping("/services/cat/tipoingresoppl")
@CrossOrigin(origins = "*")
public class TipoIngresoPPLController extends CatalogoController<CatalogoService<TipoIngresoPPL>, TipoIngresoPPL> {

	public TipoIngresoPPLController(CatalogoService<TipoIngresoPPL> service) {
		super(service);
		
	}




}
