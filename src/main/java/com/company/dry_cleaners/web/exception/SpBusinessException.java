package com.company.dry_cleaners.web.exception;

import com.company.dry_cleaners.config.SpStatusCode;

public class SpBusinessException extends StoredProcedureException {

	private static final long serialVersionUID = 1L;

    private final SpStatusCode status;

    public SpBusinessException(SpStatusCode status, String message) {
        super(status.getSpCode(), message);
        this.status = status;
    }

    public SpStatusCode getStatus() {
        return status;
    }
}
