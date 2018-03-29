package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.Parentesco;
import com.klasnic.pos.model.services.CatalogoService;

@RestController
@RequestMapping("/services/cat/parentesco")
@CrossOrigin(origins = "*")
public class ParentescoController extends CatalogoController<CatalogoService<Parentesco>, Parentesco> {

	public ParentescoController(CatalogoService<Parentesco> service) {
		super(service);
		
	}




}
