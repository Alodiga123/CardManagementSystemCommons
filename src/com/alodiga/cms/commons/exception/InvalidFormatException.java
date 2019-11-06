package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class InvalidFormatException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidFormatException(String message) {
        super(message);
    }

    public InvalidFormatException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);
    }

    public InvalidFormatException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
