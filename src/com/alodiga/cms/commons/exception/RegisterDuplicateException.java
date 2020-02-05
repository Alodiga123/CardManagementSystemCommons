package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class RegisterDuplicateException extends Exception {

    private static final long serialVersionUID = 1L;

    public RegisterDuplicateException(String message) {
        super(message);
    }

    public RegisterDuplicateException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);
    }

    public RegisterDuplicateException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
