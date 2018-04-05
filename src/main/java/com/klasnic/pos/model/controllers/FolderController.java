package com.klasnic.pos.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.Folder;
import com.klasnic.pos.model.repositories.FolderRepository;
import com.klasnic.pos.model.services.FolderService;

@RestController
@RequestMapping("/api/folders")
@CrossOrigin(origins = "*")
public class FolderController extends ActivableController<FolderService, Folder> {

	public FolderController(FolderService service) {
		super(service);
	}
	
	@Autowired
	FolderRepository folderRepository;
	
	@GetMapping(value ="father/{id}")
	@CrossOrigin(origins = "*") 
	public List<Folder> getPro(@PathVariable("id") String id){
		return folderRepository.findByIdFather(id);
	}
	
}
