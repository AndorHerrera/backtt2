package com.klasnic.pos.model.repositories;

import java.util.List;

import com.klasnic.pos.model.catalogs.Proyect;
import com.klasnic.pos.model.catalogs.User;

public interface UserRepository extends ActivableRepository<User> {
		
	List<User> findBySub(String sub);

	
}
