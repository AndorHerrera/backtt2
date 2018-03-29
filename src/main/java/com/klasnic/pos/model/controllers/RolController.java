package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.Rol;
import com.klasnic.pos.model.services.RolService;

@RestController
@RequestMapping("/services/cat/rol")
@CrossOrigin(origins = "*")
public class RolController extends ActivableController<RolService, Rol> {

	public RolController(RolService service) {
		super(service);		
	}
}
