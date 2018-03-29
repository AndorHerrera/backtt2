package com.klasnic.pos.model.services.impl;

import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Usuario;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.UsuarioRepository;
import com.klasnic.pos.model.services.UsuarioService;

@Service
public class UsuarioServiceImpl extends ActivableServiceBase<UsuarioRepository, Usuario> implements UsuarioService {

	public UsuarioServiceImpl(UsuarioRepository repository) {
		super(repository);
	}

	public Usuario findByIdUsuario(String idUsuario) {
		return getRepository().findByIdUsuario(idUsuario);
	}

	public boolean login(String idUsuario, String password) {
		Usuario usuario = getRepository().findByIdUsuario(idUsuario);
		if (usuario == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	protected void validateEntity(Usuario entity) throws DataException {
		assertRepository();
		if (!getRepository().exists(entity.getId())) {
			Usuario foundItem = getRepository().findByIdUsuario(entity.getIdUsuario());

			if (foundItem != null) {
				throw new DataException("Un usuario con identificador " + entity.getIdUsuario() + " ya existe.");
			}
		}
	}

	@Override
	public Usuario save(Usuario entity) throws DataException {
		if (entity.getIdUsuarioN() == 0) { // idUsuario Auto Generado
			assertRepository();
			Long max = getRepository().getMaxIdUsuario();
			max = max == null ? 1 : max + 1;
			entity.setIdUsuarioN(max);
			entity.setIdUsuario(String.format("%08d", max));
		}
		return super.save(entity);
	}

}
