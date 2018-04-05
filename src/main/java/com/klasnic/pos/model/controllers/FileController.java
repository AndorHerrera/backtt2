package com.klasnic.pos.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klasnic.pos.model.catalogs.File;
import com.klasnic.pos.model.repositories.FileRepository;
import com.klasnic.pos.model.services.FileService;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "*")
public class FileController extends ActivableController<FileService, File> {

	public FileController(FileService service) {
		super(service);
	}
	
	@Autowired
	FileRepository fileRepository;
	
	@GetMapping(value ="father/{id}")
	@CrossOrigin(origins = "*") 
	public List<File> getPro(@PathVariable("id") String id){
		return fileRepository.findByIdFolder(id);
	}
	
}
