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

import com.klasnic.pos.model.catalogs.Linea;
import com.klasnic.pos.model.catalogs.Serie;
import com.klasnic.pos.model.data.ErrorInfo;
import com.klasnic.pos.model.services.impl.LineaService;
import com.klasnic.pos.model.services.SerieService;

@RestController
@RequestMapping("/services/cat/serie")
@CrossOrigin(origins = "*")
public class SerieController
		extends ActivableController<SerieService, Serie> {

	private static final Logger logger = LoggerFactory.getLogger(SerieController.class);
	
	@Autowired
	LineaService lineaService;
	
	public SerieController(SerieService service) {
		super(service);
	}

	// -------------------Retrieve By CentroFederal----------------------
	@RequestMapping(value = URL_BASE + "bylinea/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Serie>> listByLinea(@PathVariable("id") String id) {
		try {
			Linea linea = lineaService.findOne(id);
			List<Serie> data = service.findByLinea(linea);

			if (data.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				// You many decide to return HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<Serie>>(data, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return new ResponseEntity(new ErrorInfo(ex.getMessage()), HttpStatus.CONFLICT);
		}
	}

}
