package com.automation.driver.factory.remote;

import com.automation.driver.manager.remote.seleniumgrid.SeleniumGridChromeManager;
import com.automation.driver.manager.remote.seleniumgrid.SeleniumGridEdgeManager;
import com.automation.driver.manager.remote.seleniumgrid.SeleniumGridFirefoxManager;
import com.automation.enums.BrowserType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SeleniumGridFactory {

    public static WebDriver getDriver(BrowserType browserType) {
        return isChromeBrowser(browserType) ? SeleniumGridChromeManager.getDriver() :
                isFirefoxBrowser(browserType) ? SeleniumGridFirefoxManager.getDriver() :
                        SeleniumGridEdgeManager.getDriver();
    }

    private static boolean isChromeBrowser(BrowserType browserType) {
        return browserType == BrowserType.CHROME;
    }

    private static boolean isFirefoxBrowser(BrowserType browserType) {
        return browserType == BrowserType.FIREFOX;
    }

}
