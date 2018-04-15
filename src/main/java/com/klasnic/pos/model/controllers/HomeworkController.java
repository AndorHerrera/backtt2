package com.klasnic.pos.model.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.dto.HomeworkDto;
import com.klasnic.pos.dto.NameUsersDto;
import com.klasnic.pos.model.catalogs.Homework;
import com.klasnic.pos.model.repositories.HomeworkRepository;
import com.klasnic.pos.model.services.HomeworkService;

@RestController
@RequestMapping("/api/homeworks")
@CrossOrigin(origins = "*")
public class HomeworkController extends ActivableController<HomeworkService, Homework> {

	public HomeworkController(HomeworkService service) {
		super(service);
	}
	
	@Autowired
	HomeworkRepository homeworkRepository;
	
	@GetMapping(value="version/minificada/{id}")
	@CrossOrigin(origins = "*") 
	public ResponseEntity<List<HomeworkDto>> min(@PathVariable("id") String id){
		
		List<Homework> response = homeworkRepository.findByKanbanId(id);		
		List<HomeworkDto> result = response.stream().map(item -> {
			HomeworkDto homework = new HomeworkDto();
			
			
			homework.setId(item.getId());
			homework.setTitle(item.getTitle());
			homework.setStatus(item.getStatus());
			homework.setDeliveryDate(item.getDeliveryDate());
			homework.setDescription(item.getDescription());			
			homework.setIdKanban(item.getKanban().getId());
			homework.setPriority(item.getPriority());
			homework.setRegisterDate(item.getFechaCreacion());
			
			if(item.getAssigned()!=null) {
				NameUsersDto assigned = new NameUsersDto();
				assigned.id = item.getAssigned().getId();
				assigned.fatherLastName = item.getAssigned().getFatherLastName();
				assigned.motherLastName = item.getAssigned().getMotherLastName();
				assigned.name = item.getAssigned().getName();
				assigned.picture = item.getAssigned().getPicture();
				homework.setAssigned(assigned);
			}
			
			if(item.getAuthor()!=null) {
				NameUsersDto author = new NameUsersDto();
				author.id = item.getAuthor().getId();
				author.fatherLastName = item.getAuthor().getFatherLastName();
				author.motherLastName = item.getAuthor().getMotherLastName();
				author.name = item.getAuthor().getName();
				author.picture = item.getAuthor().getPicture();
				homework.setAuthor(author);
			}
			
			return homework;
			
		}).collect(Collectors.toList());
		return new ResponseEntity<>(result,null, HttpStatus.OK);
	}
	
}
