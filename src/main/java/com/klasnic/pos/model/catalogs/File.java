package com.klasnic.pos.model.catalogs;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper = true)
public class File extends Activable{

	private static final long serialVersionUID = 1L;
	
	@Column(length = 50, nullable = false)
	private String idFolder;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 500, nullable = true)
	private String path;
	
	@Column(length = 50, nullable = true)
	private String type;
	
	@Column(nullable = true)
	private BigDecimal size;
	
	@Column(length = 50, nullable = true)
	private String status;
	
}
