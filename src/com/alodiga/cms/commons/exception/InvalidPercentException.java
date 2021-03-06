package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class InvalidPercentException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidPercentException(String message) {
        super(message);
    }

    public InvalidPercentException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);
    }

    public InvalidPercentException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
