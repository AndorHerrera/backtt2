package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.Proyect;
import com.klasnic.pos.model.services.ProyectService;

@RestController
@RequestMapping("/api/proyects")
@CrossOrigin(origins = "*")
public class ProyectController extends ActivableController<ProyectService, Proyect> {

	public ProyectController(ProyectService service) {
		super(service);
	}
}