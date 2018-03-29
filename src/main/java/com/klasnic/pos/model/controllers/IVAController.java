package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.IVA;
import com.klasnic.pos.model.services.IVAService;

@RestController
@RequestMapping("/services/cat/iva")
@CrossOrigin(origins = "*")
public class IVAController extends ActivableController<IVAService, IVA> {

	public IVAController(IVAService service) {
		super(service);
		
	}

}
