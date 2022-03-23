package com.automation.driver.factory;

import com.automation.config.ConfigFactory;
import com.automation.driver.entity.DriverData;
import com.automation.driver.factory.local.LocalDriverFactory;
import com.automation.driver.factory.remote.RemoteDriverFactory;
import com.automation.enums.RunType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {

    public static WebDriver getDriver(DriverData driverData) {

        return (ConfigFactory.getConfig().run_mode() == RunType.REMOTE) ?
                RemoteDriverFactory.getDriver(driverData.getBrowserRemoteModeType(), driverData.getBrowserType()) :
                LocalDriverFactory.getDriver(driverData.getBrowserType());
    }
}