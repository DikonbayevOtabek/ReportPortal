package com.epam.reportportal.framework.listeners;

import com.epam.reportportal.framework.browser.Browser;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Objects;

public class TestListener implements ITestListener {
    private final Browser browser = Browser.getInstance();
    private static final String RESULT_MESSAGE = "ITestResult can not be null";

    @Override
    public void onTestStart(ITestResult result) {
        Objects.requireNonNull(result, RESULT_MESSAGE);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Objects.requireNonNull(result, RESULT_MESSAGE);
        browser.takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Objects.requireNonNull(result, RESULT_MESSAGE);
        browser.takeScreenshot();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Objects.requireNonNull(result, RESULT_MESSAGE);
    }

    public TestListener() {
        super();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Objects.requireNonNull(result, RESULT_MESSAGE);
    }

    @Override
    public void onStart(ITestContext result) {
        Objects.requireNonNull(result, RESULT_MESSAGE);
    }

    @Override
    public void onFinish(ITestContext result) {
        Objects.requireNonNull(result, RESULT_MESSAGE);
    }
}
