package com.klasnic.pos.model.catalogs;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data()
@EqualsAndHashCode(callSuper = true)
public class Folder extends Activable{

	private static final long serialVersionUID = 1L;
	
	@Column(length = 50, nullable = false)
	private String idProyect;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = true)
	private String idFather;

	@Column(nullable = false)
	private Boolean superFather;
	
	@Column(length = 500, nullable = true)
	private String path;
	
}
