package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class InvalidQuestionException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidQuestionException(String message) {
        super(message);
    }

    public InvalidQuestionException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);
    }

    public InvalidQuestionException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
