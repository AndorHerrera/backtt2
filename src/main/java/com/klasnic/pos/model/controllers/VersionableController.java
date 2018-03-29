package com.klasnic.pos.model.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.klasnic.pos.model.catalogs.Versionable;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.data.ErrorInfo;
import com.klasnic.pos.model.data.ExampleFilter;
import com.klasnic.pos.model.data.RequestInfo;
import com.klasnic.pos.model.services.VersionableService;

import lombok.Getter;

public abstract class VersionableController<S extends VersionableService<?, PO>, PO extends Versionable> {

	private static final Logger logger = LoggerFactory.getLogger(VersionableController.class);

	protected static final String URL_BASE = "/";

	@Getter
	S service;

	protected VersionableController(S service) {
		this.service = service;
	}

	protected List<String> getIgnorePropertiesForUpdate() {
		List<String> ignoreProperties = new ArrayList<String>();
		ignoreProperties.add("Id");
		return ignoreProperties;
	}

	// -------------------Retrieve AllData----------------------
	@RequestMapping(value = URL_BASE, method = RequestMethod.GET)
	public ResponseEntity<List<PO>> listAllItems() {
		try {
			List<PO> data = service.findAll();

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

	// -------------------Retrieve DataByPage----------------------
	@RequestMapping(value = URL_BASE + "bypage/", method = RequestMethod.POST)
	public ResponseEntity<Page<PO>> listItemsByPage(@RequestBody RequestInfo<PO> requestInfo,
			UriComponentsBuilder ucBuilder) {
		try {
			logger.info("RequestPage   : {}", requestInfo.getPageRequest());
			logger.info("RequestFilter : {}", requestInfo.getFilters());
			logger.info("FilterValues  : {}", requestInfo.getFilterValues());

			Page<PO> data = null;
			if (requestInfo.getFilters().isEmpty()) {
				data = service.findAll(requestInfo.getPageRequest().createPageable());
			} else {
				Example<PO> example = ExampleFilter.createExample(requestInfo);
				data = service.findAll(example, requestInfo.getPageRequest().createPageable());
			}
			if (data.getSize() == 0) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Page<PO>>(data, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return new ResponseEntity(new ErrorInfo(ex.getMessage()), HttpStatus.CONFLICT);
		}
	}

	// -------------------Retrieve Single----------------------
	@RequestMapping(value = URL_BASE + "{id}", method = RequestMethod.GET)
	public ResponseEntity<PO> getItem(@PathVariable("id") String id) {
		try {
			logger.info("Fetching Item with id {}", id);
			try {
				PO item = service.findOne(id);
				return new ResponseEntity<PO>(item, HttpStatus.OK);
			} catch (DataException ex) {
				logger.error(ex.getMessage());
				return new ResponseEntity(new ErrorInfo(ex.getMessage()), HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return new ResponseEntity(new ErrorInfo(ex.getMessage()), HttpStatus.CONFLICT);
		}
	}

	// -------------------Create a Item----------------------
	@RequestMapping(value = URL_BASE, method = RequestMethod.POST)
	public ResponseEntity<PO> createItem(@RequestBody PO item, UriComponentsBuilder ucBuilder) {
		try {
			logger.info("Creating Item : {}", item);

			try {
				PO newItem = service.save(item);
				return new ResponseEntity<PO>(newItem, HttpStatus.CREATED);
			} catch (DataException ex) {
				String msg = String.format("No es posible guardar. %s", ex.getMessage());
				logger.error(msg);
				return new ResponseEntity(new ErrorInfo(msg), HttpStatus.CONFLICT);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return new ResponseEntity(new ErrorInfo(ex.getMessage()), HttpStatus.CONFLICT);
		}
	}

	// ------------------- Update a Item----------------------
	@RequestMapping(value = URL_BASE + "{id}", method = RequestMethod.PUT)
	public ResponseEntity<PO> updateItem(@PathVariable("id") String id, @RequestBody PO item) {
		try {
			logger.info("Updating Item : {}", item);
			PO currentItem = null;
			try {
				currentItem = service.findOne(id);
			} catch (DataException ex) {
				logger.error(ex.getMessage());
				return new ResponseEntity(new ErrorInfo(ex.getMessage()), HttpStatus.NOT_FOUND);
			}

			try {

				List<String> ignoreProperties = getIgnorePropertiesForUpdate();
				String[] ignorePropertiesBuffer = new String[ignoreProperties.size()];
				ignorePropertiesBuffer = ignoreProperties.toArray(ignorePropertiesBuffer);

				BeanUtils.copyProperties(item, currentItem, ignorePropertiesBuffer);
				PO updatedItem = service.save(currentItem);
				logger.info("Updated Item : {}", updatedItem);
				return new ResponseEntity<PO>(updatedItem, HttpStatus.OK);
			} catch (DataException ex) {
				String msg = String.format("No es posible actualizar. %s", ex.getMessage());
				logger.error(msg);
				return new ResponseEntity(new ErrorInfo(msg), HttpStatus.CONFLICT);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return new ResponseEntity(new ErrorInfo(ex.getMessage()), HttpStatus.CONFLICT);
		}
	}
	
	
	 @RequestMapping(value = URL_BASE + "{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<PO> deleteItem(@PathVariable("id") String id, @RequestBody PO item) {
		 try {
			logger.info("Fetching & Deleting Item with id {}", id);
			PO currentItem = null;
			try {
				currentItem = service.findOne(id);
			 	service.delete(currentItem);
			 	logger.info("Delete Item : {}");
				return new ResponseEntity<PO>(HttpStatus.OK);
			} catch (DataException ex) {
				logger.error(ex.getMessage());
				return new ResponseEntity(new ErrorInfo(ex.getMessage()), HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return new ResponseEntity(new ErrorInfo(ex.getMessage()), HttpStatus.CONFLICT);
		}
	 }
	
	 
	 
	 


	// ------------------- Delete a User-----------------------------------------

	/*
	 * @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.DELETE)
	 * public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
	 * logger.info("Fetching & Deleting User with id {}", id);
	 * 
	 * User user = userService.findById(id); if (user == null) {
	 * logger.error("Unable to delete. User with id {} not found.", id); return new
	 * ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id +
	 * " not found."), HttpStatus.NOT_FOUND); } userService.deleteUserById(id);
	 * return new ResponseEntity<User>(HttpStatus.NO_CONTENT); }
	 */

	// ------------------- Delete All Users-----------------------------

	/*
	 * @RequestMapping(value = "/user/", method = RequestMethod.DELETE) public
	 * ResponseEntity<User> deleteAllUsers() { logger.info("Deleting All Users");
	 * 
	 * userService.deleteAllUsers(); return new
	 * ResponseEntity<User>(HttpStatus.NO_CONTENT); }
	 */

}
