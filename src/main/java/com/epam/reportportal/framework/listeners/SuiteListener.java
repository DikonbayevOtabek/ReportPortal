package com.epam.reportportal.framework.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.util.Objects;

public class SuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        Objects.requireNonNull(suite, "Suite can not be null value");
    }
    @Override
    public void onFinish(ISuite suite) {
        Objects.requireNonNull(suite, "Suite can not be null value");
    }
}
