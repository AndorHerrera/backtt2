/**
 *
 * @author Jesús Israel
 */

package com.klasnic.pos.model.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

import com.klasnic.pos.model.catalogs.Activable;

@NoRepositoryBean
public interface ActivableRepository<T extends Activable> extends VersionableRepository<T> {
	
	List<T> findByActivo(boolean activo, Sort sort);
}
