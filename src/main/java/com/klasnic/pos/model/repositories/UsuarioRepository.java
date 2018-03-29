/**
 *
 * @author Jesús Israel
 */
package com.klasnic.pos.model.repositories;

import org.springframework.data.jpa.repository.Query;

import com.klasnic.pos.model.catalogs.Usuario;

public interface UsuarioRepository extends ActivableRepository<Usuario> {
	
	Usuario findByIdUsuario(String idUsuario);
	
	@Query("SELECT MAX(u.idUsuarioN) FROM Usuario u")
	Long getMaxIdUsuario();
}
