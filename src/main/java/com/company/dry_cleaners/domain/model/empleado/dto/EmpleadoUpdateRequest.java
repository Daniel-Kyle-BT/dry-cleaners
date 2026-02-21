package com.company.dry_cleaners.domain.model.empleado.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record EmpleadoUpdateRequest(
		@Size(max = 100) String nombre,
		@Size(max = 100) String apellido,
		@Email @Size(max = 150) String email,
		@Size(max = 20) String documento,
		@Size(max = 20) String telefono) {
}