package com.company.dry_cleaners.domain.exception.already_exists_exception;

public class EmpleadoAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmpleadoAlreadyExistsException(String message) {
        super(message);
    }
}