package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class IncorrectValueFirstCritryEspecificException extends Exception {

    private static final long serialVersionUID = 1L;

    public IncorrectValueFirstCritryEspecificException(String message) {
        super(message);
    }

    public IncorrectValueFirstCritryEspecificException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);

    }

    public IncorrectValueFirstCritryEspecificException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
