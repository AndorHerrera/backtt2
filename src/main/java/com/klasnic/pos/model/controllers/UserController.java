package com.klasnic.pos.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.User;
import com.klasnic.pos.model.repositories.UserRepository;
import com.klasnic.pos.model.services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController extends ActivableController<UserService, User> {

	public UserController(UserService service) {
		super(service);
	}
	
	@Autowired
    private UserRepository userService;
	
	@GetMapping("bysub/{id}")
	public List<User> proyectsByUser(@PathVariable("id") String id) {
		return userService.findBySub(id); 
	}
}
