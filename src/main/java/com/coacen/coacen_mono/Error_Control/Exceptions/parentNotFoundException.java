package com.coacen.coacen_mono.Error_Control.Exceptions;

public class parentNotFoundException extends Exception
{

    public parentNotFoundException() {
        super();
    }

    public parentNotFoundException(String message) {
        super(message);
    }

    public parentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public parentNotFoundException(Throwable cause) {
        super(cause);
    }

    protected parentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
