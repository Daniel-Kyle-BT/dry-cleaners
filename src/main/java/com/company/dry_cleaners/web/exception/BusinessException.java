package com.company.dry_cleaners.web.exception;

public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
    
	public BusinessException(String mensaje) {
        super(mensaje);
    }
}