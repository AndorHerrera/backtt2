package com.klasnic.pos.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Buy;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.BuyRepository;
import com.klasnic.pos.model.services.BuyService;

@Service
public class BuyServiceImpl extends ActivableServiceBase<BuyRepository, Buy>
		implements BuyService {

	@Autowired
	protected BuyServiceImpl(final BuyRepository repository) {
		super(repository);
	}

	@Override
	public List<Buy> findByActivo(boolean activo) {
		assertRepository();
		Sort sort = new Sort(Direction.ASC, "name");
		return getRepository().findByActivo(activo, sort);
	}

	@Override
	protected void validateEntity(Buy entity) throws DataException {
		
	}


}
