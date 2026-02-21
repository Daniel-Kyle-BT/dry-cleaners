package com.company.dry_cleaners.config;

import org.springframework.http.HttpStatus;

public enum ErrorType {

    VALIDATION(
            HttpStatus.BAD_REQUEST,
            "validation"
    ),

    NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "not-found"
    ),

    BUSINESS(
            HttpStatus.CONFLICT,
            "business-rule"
    ),

    DB_BUSINESS(
            HttpStatus.CONFLICT,
            "db-business-rule"
    ),

    INTERNAL(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "internal"
    );

    private final HttpStatus httpStatus;
    private final String code;

    ErrorType(HttpStatus httpStatus, String code) {
        this.httpStatus = httpStatus;
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String toTypeUri() {
        return "https://api.tuapp.com/errors/" + code;
    }
}