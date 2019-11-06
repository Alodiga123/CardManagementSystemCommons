package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class NotSingleCommissionException extends Exception {

    private static final long serialVersionUID = 1L;

    public NotSingleCommissionException(String message) {
        super(message);
    }

    public NotSingleCommissionException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);
    }

    public NotSingleCommissionException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
