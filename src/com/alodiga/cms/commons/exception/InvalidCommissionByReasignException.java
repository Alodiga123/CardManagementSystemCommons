package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class InvalidCommissionByReasignException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidCommissionByReasignException(String message) {
        super(message);
    }

    public InvalidCommissionByReasignException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);

    }

    public InvalidCommissionByReasignException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
