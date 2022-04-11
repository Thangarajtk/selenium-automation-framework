package com.automation.base;

import com.automation.enums.BrowserType;
import com.automation.utils.zerocell.TestData;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.automation.driver.Driver;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseTest {

    @BeforeMethod
    protected void setUp(Object[] data) {
        TestData testData = (TestData) data[0];
        Driver.initDriver(BrowserType.valueOf(testData.getBrowser().toUpperCase()));
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }

}
