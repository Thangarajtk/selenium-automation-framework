package com.automation.listeners;

import com.automation.annotations.FrameworkAnnotation;
import com.automation.driver.manager.DriverManager;
import com.automation.reports.ExtentLogger;
import com.automation.reports.ExtentReport;
import org.testng.*;

public class CustomListener implements ITestListener, ISuiteListener {

    private static final String TEST = "Test - <b>";

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).category());
        ExtentReport.addBrowsers();
        ExtentLogger.info(ExtentReport.getBrowserDetails(DriverManager.getDriver()));
        ExtentLogger.pass(TEST + result.getMethod().getMethodName() + "</b> is started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(TEST + result.getMethod().getMethodName() + "</b> is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(TEST + result.getMethod().getMethodName() + "</b> is failed", result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(TEST + result.getMethod().getMethodName() + "</b> is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

}
