package com.klasnic.pos.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.User;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.repositories.UserRepository;
import com.klasnic.pos.model.services.UserService;

@Service
public class UserServiceImpl extends ActivableServiceBase<UserRepository, User>
		implements UserService {

	@Autowired
	protected UserServiceImpl(final UserRepository repository) {
		super(repository);
	}

	@Override
	public List<User> findByActivo(boolean activo) {
		assertRepository();
		Sort sort = new Sort(Direction.ASC, "name");
		return getRepository().findByActivo(activo, sort);
	}

	@Override
	protected void validateEntity(User entity) throws DataException {
		
	}



}
