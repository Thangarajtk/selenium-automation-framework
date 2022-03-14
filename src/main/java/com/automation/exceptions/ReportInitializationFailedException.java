package com.automation.exceptions;

public class ReportInitializationFailedException extends FrameworkException {

    /**
     * Pass the message that needs to be appended to the stacktrace
     * @param message Details about the exception or custom message
     */
    public ReportInitializationFailedException(String message) {
        super(message);
    }

    /**
     *
     * @param message Details about the exception or custom message
     * @param cause Pass the enriched stacktrace or customised stacktrace
     */
    public ReportInitializationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
