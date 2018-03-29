package com.klasnic.pos.model.catalogs;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class Proyect extends Activable {

	private static final long serialVersionUID = 1L;
    
	public Proyect() {
	}
	
	@Column(length = 100,nullable = false)
	private String title;
	
	@Column(length = 200,nullable = false)
	private String description;
	
	@Column(nullable = true)
	private BigDecimal price;
	
	@Column(length = 10,nullable = false)
	private String version;
	
	@Lob
	@Column(nullable = true)
	private byte[] image;
	
	@Column(length = 20,nullable = false)
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@ManyToMany(targetEntity = Tag.class)
	private List<Tag> tags;
	
}
