package com.automation.driver.factory.remote;

import com.automation.driver.abstraction.IDriver;
import com.automation.driver.entity.DriverData;
import org.openqa.selenium.WebDriver;

public class RemoteDriver implements IDriver {

    @Override
    public WebDriver getDriver(DriverData driverData) {
        return RemoteDriverFactory.getDriver(driverData.getBrowserRemoteModeType(), driverData.getBrowserType());
    }
}
