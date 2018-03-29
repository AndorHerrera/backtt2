package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.Empresa;
import com.klasnic.pos.model.services.CatalogoService;

@RestController
@RequestMapping("/services/cat/empresa")
@CrossOrigin(origins = "*")
public class EmpresaController extends CatalogoController<CatalogoService<Empresa>, Empresa> {

	public EmpresaController(CatalogoService<Empresa> service) {
		super(service);
		
	}




}
