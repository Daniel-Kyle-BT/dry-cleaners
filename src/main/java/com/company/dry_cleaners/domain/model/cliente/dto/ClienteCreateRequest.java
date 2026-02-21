package com.company.dry_cleaners.domain.model.cliente.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteCreateRequest(
		@NotBlank @Size(max = 100) String nombre,
        @NotBlank @Size(max = 100) String apellido,
        @Size(max = 20) String documento,
        @Size(max = 20) String telefono
) {}
