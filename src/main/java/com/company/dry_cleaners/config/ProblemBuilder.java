package com.company.dry_cleaners.config;

import java.net.URI;

import org.springframework.http.ProblemDetail;

import jakarta.servlet.http.HttpServletRequest;

public final class ProblemBuilder {

	private ProblemBuilder() {
	}

	public static ProblemDetail build(ErrorType type, String detail, HttpServletRequest request) {
		
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(type.getHttpStatus(), detail);

		pd.setType(URI.create(type.toTypeUri()));

		if (request != null) {
			pd.setInstance(URI.create(request.getRequestURI()));
		}
		pd.setProperty("errorType", type.name());

		return pd;
	}
}