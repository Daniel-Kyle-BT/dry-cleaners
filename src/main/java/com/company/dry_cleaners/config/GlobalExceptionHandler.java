package com.company.dry_cleaners.config;

import java.util.Map;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.dry_cleaners.web.exception.BusinessException;
import com.company.dry_cleaners.web.exception.ModeloNotFoundException;
import com.company.dry_cleaners.web.exception.StoredProcedureException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private final ProblemDebugSupport debugSupport;

	public GlobalExceptionHandler(ProblemDebugSupport debugSupport) {
		this.debugSupport = debugSupport;
	}

	// VALIDACIÓN
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ProblemDetail handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {

		ProblemDetail pd = ProblemBuilder.build(ErrorType.VALIDATION, "Datos inválidos", request);

		pd.setProperty("errors", ex.getBindingResult().getFieldErrors().stream()
				.map(e -> Map.of("field", e.getField(), "message", e.getDefaultMessage())).toList());

		return pd;
	}

	// NOT FOUND
	@ExceptionHandler(ModeloNotFoundException.class)
	ProblemDetail handleNotFound(ModeloNotFoundException ex) {
		return ProblemBuilder.build(ErrorType.NOT_FOUND, ex.getMessage(), null);
	}

	// NEGOCIO
	@ExceptionHandler(BusinessException.class)
	ProblemDetail handleBusiness(BusinessException ex) {
		return ProblemBuilder.build(ErrorType.BUSINESS, ex.getMessage(), null);
	}

	@ExceptionHandler(StoredProcedureException.class)
	ProblemDetail handleSp(StoredProcedureException ex, HttpServletRequest request) {

		SpStatusCode sp = SpStatusCode.from(ex.getSpStatusCode());
	    ErrorType type = sp.getErrorType();

		ProblemDetail pd = ProblemBuilder.build(type, ex.getMessage(), request);

		pd.setProperty("spCode", ex.getSpStatusCode());

		if (debugSupport.isDebug()) {
			//pd.setProperty("procedure", ex.getProcedureName());
	        //pd.setProperty("sqlState", ex.getSqlState());
		}

		return pd;
	}

	// ERROR GENÉRICO
	@ExceptionHandler(Exception.class)
	ProblemDetail handleGeneric(Exception ex, HttpServletRequest request) {
		ProblemDetail pd = ProblemBuilder.build(ErrorType.INTERNAL, "Error interno del servidor", request);

		if (debugSupport.isDebug()) {
			StackTraceElement o = ex.getStackTrace()[0];
			pd.setProperty("exception", ex.getClass().getName());
			pd.setProperty("file", o.getFileName());
			pd.setProperty("line", o.getLineNumber());
			pd.setProperty("method", o.getMethodName());
			pd.setProperty("message", ex.getMessage());
		}

		return pd;
	}
}