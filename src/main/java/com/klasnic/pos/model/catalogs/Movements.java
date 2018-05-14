package com.klasnic.pos.model.catalogs;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class Movements extends Activable {

	private static final long serialVersionUID = 1L;
    
	public Movements() {
	}
	
	@Column(length = 500,nullable = false)
	private String description;
	
	@Column(length = 200,nullable = false)
	private String type;
	
	@Column(length = 200,nullable = true)
	private String idProyect;
	
	@Column(length = 200,nullable = true)
	private String idUser;
	
	@Column(length = 200,nullable = true)
	private String sub;
	
}
