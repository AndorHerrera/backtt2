package com.klasnic.pos.model.repositories;

import java.util.List;

import com.klasnic.pos.model.catalogs.Homework;
import com.klasnic.pos.model.catalogs.Kanban;
public interface HomeworkRepository extends ActivableRepository<Homework> {
		
	List<Homework> findByKanbanId(String id);

}
