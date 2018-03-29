package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.Linea;
import com.klasnic.pos.model.services.CatalogoService;

@RestController
@RequestMapping("/services/cat/linea")
@CrossOrigin(origins = "*")
public class LineaController extends CatalogoController<CatalogoService<Linea>, Linea> {

	public LineaController(CatalogoService<Linea> service) {
		super(service);
		
	}

}
