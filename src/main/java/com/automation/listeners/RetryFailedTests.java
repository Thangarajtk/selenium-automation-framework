package com.automation.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.automation.enums.ConfigProperties;
import com.automation.utils.configloader.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private final int maxRetry = Integer.parseInt(PropertyUtils.get(ConfigProperties.RETRY_COUNT));

    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;
        if (PropertyUtils.get(ConfigProperties.RETRY_FAILED_TESTS).equalsIgnoreCase("yes")) {
            value = count < maxRetry;
            count++;
        }
        return value;
    }
}
