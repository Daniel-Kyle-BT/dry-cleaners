package com.company.dry_cleaners.domain.model.empleado.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmpleadoCreateRequest(
		@NotBlank @Size(max = 100) String nombre,
        @NotBlank @Size(max = 100) String apellido,
        @NotBlank @Email @Size(max = 150) String email,
        @NotBlank @Size(max = 20) String documento,
        @Size(max = 20) String telefono
) {}
