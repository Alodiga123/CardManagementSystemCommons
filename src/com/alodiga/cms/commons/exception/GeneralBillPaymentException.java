package com.alodiga.cms.commons.exception;

import org.apache.log4j.Logger;

public class GeneralBillPaymentException extends Exception {

    private static final long serialVersionUID = 1L;
    private String errorCode;

    public GeneralBillPaymentException(String message,String errorCode) {
        super(message);
        this.errorCode=errorCode;
    }

    public GeneralBillPaymentException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);

    }

    public GeneralBillPaymentException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
    
}
