package com.kutash.inheritance.exception;

public class EmployeeTypeNotFoundException extends Exception {

    public EmployeeTypeNotFoundException() {
    }

    public EmployeeTypeNotFoundException(String message) {
        super(message);
    }

    public EmployeeTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeTypeNotFoundException(Throwable cause) {
        super(cause);
    }

    public EmployeeTypeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
