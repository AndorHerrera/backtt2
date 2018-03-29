package com.klasnic.pos.model.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.Usuario;
import com.klasnic.pos.model.services.UsuarioService;

@RestController
@RequestMapping("/services/cat/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController extends ActivableController<UsuarioService, Usuario> {

	public UsuarioController(UsuarioService service) {
		super(service);
		
	}
	
	@Override
	protected List<String> getIgnorePropertiesForUpdate() {
		List<String> ignoreProperties = super.getIgnorePropertiesForUpdate();
		ignoreProperties.add("password");
		return ignoreProperties;
	}

}
