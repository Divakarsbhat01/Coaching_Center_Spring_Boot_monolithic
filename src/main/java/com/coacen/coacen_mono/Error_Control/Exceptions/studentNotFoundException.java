package com.coacen.coacen_mono.Error_Control.Exceptions;

public class studentNotFoundException extends Exception
{
    public studentNotFoundException(String message)
    {
        super(message);
    }

    public studentNotFoundException() {
        super();
    }

    public studentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public studentNotFoundException(Throwable cause) {
        super(cause);
    }

    protected studentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
