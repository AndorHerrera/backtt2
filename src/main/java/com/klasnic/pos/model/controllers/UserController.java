package com.klasnic.pos.model.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.User;
import com.klasnic.pos.model.services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController extends ActivableController<UserService, User> {

	public UserController(UserService service) {
		super(service);
	}
}
