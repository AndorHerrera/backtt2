package com.klasnic.pos.model.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.CentroFederal;
import com.klasnic.pos.model.catalogs.ModuloCentroFederal;
import com.klasnic.pos.model.data.ErrorInfo;
import com.klasnic.pos.model.services.CentroFederalService;
import com.klasnic.pos.model.services.ModuloCentroFederalService;

@RestController
@RequestMapping("/services/cat/modulocentrofederal")
@CrossOrigin(origins = "*")
public class ModuloCentroFederalController
		extends ActivableController<ModuloCentroFederalService, ModuloCentroFederal> {

	private static final Logger logger = LoggerFactory.getLogger(ModuloCentroFederalController.class);
	
	@Autowired
	CentroFederalService centroFederalService;
	
	public ModuloCentroFederalController(ModuloCentroFederalService service) {
		super(service);
	}

	// -------------------Retrieve By CentroFederal----------------------
	@RequestMapping(value = URL_BASE + "bycentrofederal/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<ModuloCentroFederal>> listByCentroFederal(@PathVariable("id") String id) {
		try {
			CentroFederal centroFederal = centroFederalService.findOne(id);
			List<ModuloCentroFederal> data = service.findByCentroFederal(centroFederal);

			if (data.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				// You many decide to return HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<ModuloCentroFederal>>(data, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return new ResponseEntity(new ErrorInfo(ex.getMessage()), HttpStatus.CONFLICT);
		}
	}

}
