package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class SMSFailureException extends Exception {

    private static final long serialVersionUID = 1L;

    public SMSFailureException(String message) {
        super(message);
    }

    public SMSFailureException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);
    }

    public SMSFailureException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
