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
public class User extends Activable{

	private static final long serialVersionUID = 1L;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private String fatherLastName;
	
	@Column(length = 50, nullable = true)
	private String motherLastName;
	
	@Column(nullable = true)
	//@JsonFormat(pattern="dd/MM/yyyy")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date birthday;
	
	@Column(length = 12, nullable = true)
	private String phone;
	
	@Column(length = 50, nullable = true)
	private String email;
	
	@Column(length = 1, nullable = false)
	private Character gender;
	
	@Column(length = 350, nullable = true)
	private String password;


}
