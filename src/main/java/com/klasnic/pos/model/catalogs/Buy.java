package com.klasnic.pos.model.catalogs;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper=true)
public class Buy extends Activable {

	private static final long serialVersionUID = 1L;
    
	public Buy() {
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Proyect proyect;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
}
