package com.klasnic.pos.model.catalogs;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(length = 500, nullable = true)
	private String aboutme;

}
