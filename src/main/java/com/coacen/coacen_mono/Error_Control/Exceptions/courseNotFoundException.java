package com.coacen.coacen_mono.Error_Control.Exceptions;

public class courseNotFoundException extends Exception
{
    public courseNotFoundException() {
        super();
    }

    public courseNotFoundException(String message) {
        super(message);
    }

    public courseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public courseNotFoundException(Throwable cause) {
        super(cause);
    }

    protected courseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
