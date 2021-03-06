package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class TopUpCommissionPercentNotAvailableException extends Exception {

    private static final long serialVersionUID = 1L;

    public TopUpCommissionPercentNotAvailableException(String message) {
        super(message);
    }

    public TopUpCommissionPercentNotAvailableException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);

    }

    public TopUpCommissionPercentNotAvailableException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
