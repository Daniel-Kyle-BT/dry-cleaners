package com.company.dry_cleaners.domain.model.cliente.dto;

import jakarta.validation.constraints.Size;

public record ClienteUpdateRequest(
		@Size(max = 100) String nombre,
		@Size(max = 100) String apellido,
		@Size(max = 20) String documento,
		@Size(max = 20) String telefono) {
}