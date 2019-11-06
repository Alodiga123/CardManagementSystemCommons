package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class CommissionProviderNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public CommissionProviderNotFoundException(String message) {
        super(message);
    }

    public CommissionProviderNotFoundException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);
    }

    public CommissionProviderNotFoundException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
