package com.klasnic.pos.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.klasnic.pos.model.catalogs.Buy;
import com.klasnic.pos.model.repositories.BuyRepository;
import com.klasnic.pos.model.services.BuyService;

@RestController
@RequestMapping("/api/buys")
@CrossOrigin(origins = "*")
public class BuyController extends ActivableController<BuyService, Buy> {
	
	public BuyController(BuyService service) {
		super(service);
	}
	
	@Autowired
	BuyRepository buyRepository;
	
	@GetMapping(value ="user/{id}")
	@CrossOrigin(origins = "*") 
	public List<Buy> getBuys(@PathVariable("id") String id){
		return buyRepository.findByUser_Sub(id);
	}
	
}
