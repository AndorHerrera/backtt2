package com.klasnic.pos.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.Producto;
import com.klasnic.pos.model.data.ErrorInfo;
import com.klasnic.pos.model.repositories.ProductoRepository;
import com.klasnic.pos.model.services.ProductoService;

@RestController
@RequestMapping("/services/cat/producto")
@CrossOrigin(origins = "*")
public class ProductoController extends ActivableController<ProductoService, Producto> {

	@Autowired
	ProductoRepository productoRepository;
	
	public ProductoController(ProductoService service) {
		super(service);
		
	}
	
	@RequestMapping(value = URL_BASE + "byclave/{clave}", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> listByClave(@PathVariable("clave") String clave) {
		try {
			List<Producto> data = service.findByClave(clave);
			
			if (data.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				// You many decide to return HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<Producto>>(data, HttpStatus.OK);
		} catch (Exception ex) {
			//logger.error(ex.getMessage());
			return new ResponseEntity(new ErrorInfo(ex.getMessage()), HttpStatus.CONFLICT);
		}
	}


}