package com.company.dry_cleaners.domain.exception.not_found_exception;


public class EmpleadoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmpleadoNotFoundException(Long empleadoId) {
        super("Empleado no encontrado. id=" + empleadoId);
    }
}