package com.coacen.coacen_mono.Error_Control.Exceptions;

public class teacherNotFoundException extends Exception
{
    public teacherNotFoundException() {
        super();
    }

    public teacherNotFoundException(String message) {
        super(message);
    }

    public teacherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public teacherNotFoundException(Throwable cause) {
        super(cause);
    }

    protected teacherNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
