/**
 *
 * @author Jesús Israel
 */

package com.klasnic.pos.model.repositories;


import org.springframework.data.repository.NoRepositoryBean;

import com.klasnic.pos.model.catalogs.Catalogo;

@NoRepositoryBean
public interface CatalogoRepository<T extends Catalogo> extends ActivableRepository<T> {
	
	T findByClave(String clave);
}
