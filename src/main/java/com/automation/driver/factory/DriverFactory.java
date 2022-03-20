package com.automation.driver.factory;

import com.automation.config.ConfigFactory;
import com.automation.driver.factory.local.LocalDriverFactory;
import com.automation.driver.factory.remote.RemoteDriverFactory;
import com.automation.enums.BrowserRemoteModeType;
import com.automation.enums.BrowserType;
import com.automation.enums.RunType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {

    public static WebDriver getDriver(BrowserType browser) {
        RunType runMode = ConfigFactory.getConfig().run_mode();
        BrowserRemoteModeType browserRemoteMode = ConfigFactory.getConfig().remote_mode();

        return (runMode == RunType.REMOTE) ? RemoteDriverFactory.getDriver(browserRemoteMode, browser) :
                LocalDriverFactory.getDriver(browser);
    }
}