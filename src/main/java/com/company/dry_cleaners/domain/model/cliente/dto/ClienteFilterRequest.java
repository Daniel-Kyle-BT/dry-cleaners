package com.company.dry_cleaners.domain.model.cliente.dto;

public record ClienteFilterRequest(String fullName, Boolean activo) {

	public boolean hasFullName() {
		return fullName != null && !fullName.isBlank();
	}

	public boolean hasActivo() {
		return activo != null;
	}
}