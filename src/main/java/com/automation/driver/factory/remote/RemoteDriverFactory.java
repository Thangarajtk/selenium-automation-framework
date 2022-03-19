package com.automation.driver.factory.remote;

import com.automation.enums.BrowserRemoteModeType;
import com.automation.enums.BrowserType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RemoteDriverFactory {

    public static WebDriver getDriver(BrowserRemoteModeType browserRemoteMode, BrowserType browserType) {

        if (browserRemoteMode == BrowserRemoteModeType.SELENIUMGRID) {
            return SeleniumGridFactory.getDriver(browserType);
        }
        else {
            return SelenoidFactory.getDriver(browserType);
        }
    }
}
