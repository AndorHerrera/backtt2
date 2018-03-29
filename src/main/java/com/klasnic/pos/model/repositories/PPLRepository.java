/**
 *
 * @author Jesús Israel
 */
package com.klasnic.pos.model.repositories;

import com.klasnic.pos.model.catalogs.PPL;

public interface PPLRepository extends ActivableRepository<PPL> {
	
	//Usuario findByIdUsuario(String idUsuario);
	PPL findByCiPPL(String ciPPL);
	PPL findByFolioExpediente(String folioExpediente);
}
