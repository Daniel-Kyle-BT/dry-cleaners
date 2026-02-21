package com.company.dry_cleaners.domain.exception.forbidden_exception;

public class ForbiddenEmpleadoAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ForbiddenEmpleadoAccessException() {
        super("No tiene permiso para acceder a este empleado");
    }
}