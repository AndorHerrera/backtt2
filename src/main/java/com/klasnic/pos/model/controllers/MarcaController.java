package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.Marca;
import com.klasnic.pos.model.services.CatalogoService;

@RestController
@RequestMapping("/services/cat/marca")
@CrossOrigin(origins = "*")
public class MarcaController extends CatalogoController<CatalogoService<Marca>, Marca> {

	public MarcaController(CatalogoService<Marca> service) {
		super(service);
		
	}

}
