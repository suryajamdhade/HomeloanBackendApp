package com.cm.app.customexceptions;

public class CreditScoreServiceException extends RuntimeException {
    
    public CreditScoreServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}