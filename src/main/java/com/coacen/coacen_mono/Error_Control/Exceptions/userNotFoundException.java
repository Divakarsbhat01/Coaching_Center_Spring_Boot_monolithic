package com.coacen.coacen_mono.Error_Control.Exceptions;

public class userNotFoundException extends Exception
{
    public userNotFoundException() {
        super();
    }

    public userNotFoundException(String message) {
        super(message);
    }

    public userNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public userNotFoundException(Throwable cause) {
        super(cause);
    }

    protected userNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
