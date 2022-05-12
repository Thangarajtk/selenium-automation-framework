package com.automation.driver.factory.local;

import com.automation.driver.abstraction.IDriver;
import com.automation.driver.entity.DriverData;
import org.openqa.selenium.WebDriver;

public class LocalDriverImpl implements IDriver {

    @Override
    public WebDriver getDriver(DriverData driverData) {
        return LocalDriverFactory.getDriver(driverData.getBrowserType());
    }
}
