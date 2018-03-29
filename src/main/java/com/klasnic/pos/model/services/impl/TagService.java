package com.klasnic.pos.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klasnic.pos.model.catalogs.Tag;
import com.klasnic.pos.model.repositories.TagRepository;

@Service
public class TagService extends CatalogoServiceBase<Tag> {
		
	@Autowired
	public TagService(final TagRepository repository) {
		super(repository);
	}
}