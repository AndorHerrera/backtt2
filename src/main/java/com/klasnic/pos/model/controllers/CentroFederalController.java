package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.CentroFederal;
import com.klasnic.pos.model.services.CentroFederalService;

@RestController
@RequestMapping("/services/cat/centrofederal")
@CrossOrigin(origins = "*")
public class CentroFederalController extends ActivableController<CentroFederalService, CentroFederal> {

	public CentroFederalController(CentroFederalService service) {
		super(service);
		
	}
}
