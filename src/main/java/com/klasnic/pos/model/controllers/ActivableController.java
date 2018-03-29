package com.klasnic.pos.model.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.klasnic.pos.model.catalogs.Activable;
import com.klasnic.pos.model.data.ErrorInfo;
import com.klasnic.pos.model.services.ActivableService;

public abstract class ActivableController<S extends ActivableService<?, PO>, PO extends Activable>
		extends VersionableController<S, PO> {

	private static final Logger logger = LoggerFactory.getLogger(ActivableController.class);

	protected ActivableController(S service) {
		super(service);
	}

	// -------------------Retrieve AllActivos----------------------
	@RequestMapping(value = URL_BASE + "active", method = RequestMethod.GET)
	public ResponseEntity<List<PO>> listAllItemsActivos() {
		try {
			List<PO> data = getService().findByActivo(true);

			if (data.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				// You many decide to return HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<PO>>(data, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return new ResponseEntity(new ErrorInfo(ex.getMessage()), HttpStatus.CONFLICT);
		}
	}
}
