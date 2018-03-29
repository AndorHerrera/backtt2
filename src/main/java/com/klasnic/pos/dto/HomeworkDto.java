package com.klasnic.pos.dto;


import java.util.Date;
import java.util.List;

import com.klasnic.pos.model.catalogs.User;

import lombok.Data;

@Data
public class HomeworkDto {
	
	private String id;
	
	private String title;
	
	private String description;
	
	private String priority;
	
	private Date deliveryDate;

	private Date registerDate;
	
	private String idKanban;

	private NameUsersDto author;
		
	private NameUsersDto assigned;

	private String status;
	
}
