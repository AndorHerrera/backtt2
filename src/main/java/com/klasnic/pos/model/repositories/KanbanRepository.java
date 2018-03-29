package com.klasnic.pos.model.repositories;

import java.util.List;

import com.klasnic.pos.model.catalogs.Kanban;

public interface KanbanRepository extends ActivableRepository<Kanban> {
	
	List<Kanban> findTop1ByProyectId(String id);

}
