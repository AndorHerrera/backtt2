package com.klasnic.pos.model.catalogs;

public class Roles {

	private static Rol[] roles = {
			new Rol("1b0299b8-a4a9-4815-bcb4-dd9a975bc8ed", "Administrador"),
			new Rol("03897f23-5455-4341-9ab9-04eefcd647a8", "Enrolador de PPLs"),
			new Rol("30cd193f-2599-4c59-b5df-cdcd57f39600", "Autorizador de compras"),
			new Rol("1de8c774-70ce-480a-b040-316f0ad4900d", "Administrador de contrato"),
	};
	
	static public Rol[] getRoles() {
		return roles;
	}
}
