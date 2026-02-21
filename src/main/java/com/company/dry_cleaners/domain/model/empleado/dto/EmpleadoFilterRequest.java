package com.company.dry_cleaners.domain.model.empleado.dto;

public record EmpleadoFilterRequest(String fullName, String codigo, Boolean activo) {

	public boolean hasFullName() {
		return fullName != null && !fullName.isBlank();
	}

	public boolean hasCodigo() {
		return codigo != null && !codigo.isBlank();
	}

	public boolean hasActivo() {
		return activo != null;
	}
}
