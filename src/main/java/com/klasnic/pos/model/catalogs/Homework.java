package com.klasnic.pos.model.catalogs;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper = true)
public class Homework extends Activable{

	private static final long serialVersionUID = 1L;
	
	@Column(length = 100, nullable = false)
	private String title;
	
	@Column(length = 500, nullable = false)
	private String description;
	
	@Column(length = 50, nullable = true)
	private String priority;
	
	@Column(nullable = true)
	//@JsonFormat(pattern="dd/MM/yyyy")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Kanban kanban;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User author;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User assigned;

	@Column(length = 50, nullable = true)
	private String status;

}
