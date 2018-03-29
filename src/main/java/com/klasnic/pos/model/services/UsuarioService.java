package com.klasnic.pos.model.services;

import com.klasnic.pos.model.catalogs.Usuario;
import com.klasnic.pos.model.repositories.UsuarioRepository;

public interface UsuarioService	extends ActivableService<UsuarioRepository, Usuario>{

	Usuario findByIdUsuario(String idUsuario);
	boolean login(String idUsuario, String password);
}
