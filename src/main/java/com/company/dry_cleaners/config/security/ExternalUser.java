package com.company.dry_cleaners.config.security;

public record ExternalUser(
	    String username,
	    String email,
	    String role
	) {}