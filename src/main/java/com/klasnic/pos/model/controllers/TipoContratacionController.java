package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.TipoContratacion;
import com.klasnic.pos.model.services.CatalogoService;

@RestController
@RequestMapping("/services/cat/tipocontratacion")
@CrossOrigin(origins = "*")
public class TipoContratacionController extends CatalogoController<CatalogoService<TipoContratacion>, TipoContratacion> {

	public TipoContratacionController(CatalogoService<TipoContratacion> service) {
		super(service);
		
	}




}
