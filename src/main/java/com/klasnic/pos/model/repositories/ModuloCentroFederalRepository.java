/**
 *
 * @author Jesús Israel
 */

package com.klasnic.pos.model.repositories;

import java.util.List;

import com.klasnic.pos.model.catalogs.CentroFederal;
import com.klasnic.pos.model.catalogs.ModuloCentroFederal;

public interface ModuloCentroFederalRepository extends ActivableRepository<ModuloCentroFederal> {
	
	ModuloCentroFederal findByClave(String clave);
	List<ModuloCentroFederal> findByCentroFederalAndActivoTrueOrderByDescripcion(CentroFederal centroFederal);
}
