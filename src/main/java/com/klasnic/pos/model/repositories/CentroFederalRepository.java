/**
 *
 * @author Jesús Israel
 */

package com.klasnic.pos.model.repositories;

import com.klasnic.pos.model.catalogs.CentroFederal;

public interface CentroFederalRepository extends ActivableRepository<CentroFederal> {
	
	CentroFederal findByClave(String clave);
}
