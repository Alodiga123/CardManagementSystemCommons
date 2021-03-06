package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class DisabledAccountException extends Exception {

    private static final long serialVersionUID = 1L;

    public DisabledAccountException(String message) {
        super(message);
    }

    public DisabledAccountException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);
    }

    public DisabledAccountException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
