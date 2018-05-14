package com.klasnic.pos.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.klasnic.pos.model.catalogs.Movements;
import com.klasnic.pos.model.repositories.MovementsRepository;
import com.klasnic.pos.model.services.MovementsService;

@RestController
@RequestMapping("/api/movements")
@CrossOrigin(origins = "*")
public class MovementsController extends ActivableController<MovementsService, Movements> {
	
	public MovementsController(MovementsService service) {
		super(service);
	}
	
	@Autowired
    private MovementsRepository movementesRepository;
	
	@GetMapping("user/{id}")
	public List<Movements> proyectsByUser(@PathVariable("id") String id) {
		return movementesRepository.findBySub(id);
	}
	
}
