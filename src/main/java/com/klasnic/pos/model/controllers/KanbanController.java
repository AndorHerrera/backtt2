package com.klasnic.pos.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.klasnic.pos.model.catalogs.Kanban;
import com.klasnic.pos.model.repositories.KanbanRepository;
import com.klasnic.pos.model.services.KanbanService;

@RestController
@RequestMapping("/api/kanbans")
@CrossOrigin(origins = "*")
public class KanbanController extends ActivableController<KanbanService, Kanban> {
	
	public KanbanController(KanbanService service) {
		super(service);
	}
	
	@Autowired
	KanbanRepository kanbanRepository;
	
	@GetMapping(value ="proyect/{id}")
	@CrossOrigin(origins = "*") 
	public List<Kanban> getPro(@PathVariable("id") String id){
		return kanbanRepository.findTop1ByProyectId(id);
	}
	
}
