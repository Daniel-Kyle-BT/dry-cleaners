package com.company.dry_cleaners.domain.model.cliente.dto;

public record ClienteResponse(
		Long id,
	    String nombre,
	    String apellido,
	    String documento,
	    String telefono,
	    String codigo,
	    boolean activo
	) {}