package com.company.dry_cleaners.config;

import java.util.Arrays;

public enum SpStatusCode {

    // VALIDACIONES
    REQUIRED_PARAMS(
            10001,
            ErrorType.DB_BUSINESS
    ),

    INVALID_DATE_RANGE(
            10002,
            ErrorType.DB_BUSINESS
    ),

    AREA_NOT_FOUND(
            12001,
            ErrorType.NOT_FOUND
    ),

    // FALLBACK
    UNKNOWN(
            -1,
            ErrorType.INTERNAL
    );

    private final int spCode;
    private final ErrorType errorType;

    SpStatusCode(int spCode, ErrorType errorType) {
        this.spCode = spCode;
        this.errorType = errorType;
    }

    public int getSpCode() {
        return spCode;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public static SpStatusCode from(int spCode) {
        return Arrays.stream(values())
                .filter(c -> c.spCode == spCode)
                .findFirst()
                .orElse(UNKNOWN);
    }
}