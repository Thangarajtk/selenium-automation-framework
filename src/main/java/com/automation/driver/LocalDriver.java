package com.automation.driver;

import com.automation.driver.entity.DriverData;
import com.automation.driver.factory.local.LocalDriverFactory;
import org.openqa.selenium.WebDriver;

public class LocalDriver implements IDriver {

    @Override
    public WebDriver getDriver(DriverData driverData) {
        return LocalDriverFactory.getDriver(driverData.getBrowserType());
    }
}
