package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.EstadoCivil;
import com.klasnic.pos.model.services.CatalogoService;

@RestController
@RequestMapping("/services/cat/estadocivil")
@CrossOrigin(origins = "*")
public class EstadoCivilController extends CatalogoController<CatalogoService<EstadoCivil>, EstadoCivil> {

	public EstadoCivilController(CatalogoService<EstadoCivil> service) {
		super(service);
		
	}




}
