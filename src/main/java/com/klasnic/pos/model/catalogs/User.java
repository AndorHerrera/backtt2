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
	
	@Column(length = 100, nullable = false,unique=true)
	private String sub;

	@Column(length = 100, nullable = true)
	private String nickname;
	
	@Column(length = 100, nullable = true)
	private String name;
	
	@Column(length = 50, nullable = true)
	private String fatherLastName;
	
	@Column(length = 50, nullable = true)
	private String motherLastName;
	
	@Column(length = 250, nullable = true)
	private String picture;


}
