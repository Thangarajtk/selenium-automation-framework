package com.automation.base;

import com.automation.zerocell.TestData;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.automation.driver.Driver;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseTest {

    @BeforeMethod
    protected void setUp(Object[] data) throws Exception {
        TestData testData = (TestData) data[0];
        System.out.println(testData);
        Driver.initDriver(testData.getBrowser(), testData.getVersion());
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }

}
