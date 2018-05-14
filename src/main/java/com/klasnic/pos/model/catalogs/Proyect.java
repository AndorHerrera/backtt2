package com.klasnic.pos.model.catalogs;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class Proyect extends Activable {

	private static final long serialVersionUID = 1L;
    
	public Proyect() {
	}
	
	@Column(length = 500,nullable = false)
	private String title;
	
	@Column(length = 500,nullable = false)
	private String description;
	
	@Column(nullable = true)
	private BigDecimal price;
	
	@Column(nullable = true)
	private BigDecimal priceMarket;
	
	@Column(nullable = true)
	private BigDecimal commission;
	
	@Column(length = 10,nullable = false)
	private String version;
	
	@Lob
	@Column(nullable = true)
	private byte[] image;
	
	@Column(length = 20,nullable = false)
	private String status;
	
	@ManyToMany(targetEntity = Tag.class)
	private List<Tag> tags;
	
	@Column(nullable = true,columnDefinition="tinyint(1) default 0")
	private Boolean sonar;
	
	@Column(length = 40,nullable = true)
	private String idUser;
	
	@ManyToMany(targetEntity = User.class)
	private List<User> users;
	
}
