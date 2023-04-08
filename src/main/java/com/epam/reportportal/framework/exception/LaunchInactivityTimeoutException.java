package com.epam.reportportal.framework.exception;

public class LaunchInactivityTimeoutException extends RuntimeException {
    public LaunchInactivityTimeoutException() {
        super("Launch Inactivity Timeout must be set");
    }
}
