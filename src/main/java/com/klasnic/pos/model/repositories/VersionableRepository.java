/**
 *
 * @author Jesús Israel
 */

package com.klasnic.pos.model.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.klasnic.pos.model.catalogs.Versionable;

@NoRepositoryBean
public interface VersionableRepository<T extends Versionable> extends PersistentRepository<T> {
	
	// Find por creación o modificaciones mayores a una fecha
	List<T> findByFechaCreacionGreaterThan(Date date);
}
