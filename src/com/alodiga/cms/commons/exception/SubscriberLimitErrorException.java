package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class SubscriberLimitErrorException extends Exception {

    private static final long serialVersionUID = 1L;

    public SubscriberLimitErrorException(String message) {
        super(message);
    }

    public SubscriberLimitErrorException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);
    }

    public SubscriberLimitErrorException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
