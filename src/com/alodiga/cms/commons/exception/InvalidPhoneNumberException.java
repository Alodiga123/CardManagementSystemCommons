package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class InvalidPhoneNumberException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidPhoneNumberException(String message) {
        super(message);
    }

    public InvalidPhoneNumberException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);

    }

    public InvalidPhoneNumberException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
