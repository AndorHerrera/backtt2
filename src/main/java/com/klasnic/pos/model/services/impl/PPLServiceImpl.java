package com.klasnic.pos.model.services.impl;

import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.PPL;
import com.klasnic.pos.model.catalogs.ReferenciaPPL;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.PPLRepository;
import com.klasnic.pos.model.services.PPLService;

@Service
public class PPLServiceImpl extends ActivableServiceBase<PPLRepository, PPL> implements PPLService {

	public PPLServiceImpl(PPLRepository repository) {
		super(repository);
	}

	/*public Usuario findByIdUsuario(String idUsuario) {
		return getRepository().findByIdUsuario(idUsuario);
	}

	public boolean login(String idUsuario, String password) {
		Usuario usuario = getRepository().findByIdUsuario(idUsuario);
		if (usuario == null) {
			return false;
		} else {
			return true;
		}
	}*/
	
	@Override
	public PPL save(PPL entity) throws DataException {
		for(ReferenciaPPL referenciaPPL : entity.getReferencias()) {
			this.updateVersionableData(referenciaPPL);
		}
		
		if(entity.getDatosFiscales() != null) {
			this.updateVersionableData(entity.getDatosFiscales());
		}
		return super.save(entity);
	}

	@Override
	protected void validateEntity(PPL entity) throws DataException {
		assertRepository();
		if (!getRepository().exists(entity.getId())) {
			PPL foundItem = getRepository().findByCiPPL(entity.getCiPPL());

			if (foundItem != null) {
				throw new DataException("Un ppl con ci " + entity.getCiPPL() + " ya existe.");
			}
		}
		
		PPL foundItem = getRepository().findByFolioExpediente(entity.getFolioExpediente());
		if(foundItem != null) {
			if(!foundItem.getId().equals(entity.getId())) {
				throw new DataException("Un ppl con Folio Expediente " + entity.getFolioExpediente() + " ya existe.");				
			}
		}
	}
}
