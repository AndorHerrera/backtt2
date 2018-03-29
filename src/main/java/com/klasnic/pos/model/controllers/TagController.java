package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.Tag;
import com.klasnic.pos.model.services.CatalogoService;

@RestController
@RequestMapping("/api/tags")
@CrossOrigin(origins = "*")
public class TagController extends CatalogoController<CatalogoService<Tag>, Tag> {

	public TagController(CatalogoService<Tag> service) {
		super(service);
		
	}

}