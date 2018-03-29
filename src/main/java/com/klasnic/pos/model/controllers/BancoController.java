package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.Banco;
import com.klasnic.pos.model.services.CatalogoService;

@RestController
@RequestMapping("/services/cat/banco")
@CrossOrigin(origins = "*")
public class BancoController extends CatalogoController<CatalogoService<Banco>, Banco> {

	public BancoController(CatalogoService<Banco> service) {
		super(service);
		
	}




}
