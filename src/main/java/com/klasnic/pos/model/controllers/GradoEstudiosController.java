package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.GradoEstudios;
import com.klasnic.pos.model.services.CatalogoService;

@RestController
@RequestMapping("/services/cat/gradoestudios")
@CrossOrigin(origins = "*")
public class GradoEstudiosController extends CatalogoController<CatalogoService<GradoEstudios>, GradoEstudios> {

	public GradoEstudiosController(CatalogoService<GradoEstudios> service) {
		super(service);
		
	}




}
