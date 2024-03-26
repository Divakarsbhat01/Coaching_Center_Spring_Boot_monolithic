package com.coacen.coacen_mono.Error_Control.Exceptions;

public class courseMaterialNotFoundException extends Exception
{
    public courseMaterialNotFoundException() {
        super();
    }

    public courseMaterialNotFoundException(String message) {
        super(message);
    }

    public courseMaterialNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public courseMaterialNotFoundException(Throwable cause) {
        super(cause);
    }

    protected courseMaterialNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
