package com.automation.driver.factory.remote;

import com.automation.driver.manager.remote.selenoid.SelenoidChromeManager;
import com.automation.driver.manager.remote.selenoid.SelenoidFirefoxManager;
import com.automation.enums.BrowserType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SelenoidFactory {

    public static WebDriver getDriver(BrowserType browserType) {
        return isChromeBrowser(browserType) ? SelenoidChromeManager.getDriver() :
                SelenoidFirefoxManager.getDriver();
    }

    private static boolean isChromeBrowser(BrowserType browserType) {
        return browserType == BrowserType.CHROME;
    }
}
