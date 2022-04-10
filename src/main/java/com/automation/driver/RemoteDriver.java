package com.automation.driver;

import com.automation.driver.entity.DriverData;
import com.automation.driver.factory.remote.RemoteDriverFactory;
import org.openqa.selenium.WebDriver;

public class RemoteDriver implements IDriver {

    @Override
    public WebDriver getDriver(DriverData driverData) {
        return RemoteDriverFactory.getDriver(driverData.getBrowserRemoteModeType(), driverData.getBrowserType());
    }
}
