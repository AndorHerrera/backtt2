package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.Unidad;
import com.klasnic.pos.model.services.CatalogoService;

@RestController
@RequestMapping("/services/cat/unidad")
@CrossOrigin(origins = "*")
public class UnidadController extends CatalogoController<CatalogoService<Unidad>, Unidad> {

	public UnidadController(CatalogoService<Unidad> service) {
		super(service);
		
	}

}