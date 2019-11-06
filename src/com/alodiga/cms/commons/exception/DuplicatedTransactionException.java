package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class DuplicatedTransactionException extends Exception {

    private static final long serialVersionUID = 1L;

    public DuplicatedTransactionException(String message) {
        super(message);
    }

    public DuplicatedTransactionException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);

    }

    public DuplicatedTransactionException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
