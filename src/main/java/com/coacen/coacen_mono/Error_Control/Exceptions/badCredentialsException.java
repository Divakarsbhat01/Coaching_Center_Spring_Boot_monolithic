package com.coacen.coacen_mono.Error_Control.Exceptions;

public class badCredentialsException extends Exception
{
    public badCredentialsException() {
        super();
    }

    public badCredentialsException(String message) {
        super(message);
    }

    public badCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public badCredentialsException(Throwable cause) {
        super(cause);
    }

    protected badCredentialsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

