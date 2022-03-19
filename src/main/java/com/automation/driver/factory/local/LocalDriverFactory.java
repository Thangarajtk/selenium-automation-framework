package com.automation.driver.factory.local;

import com.automation.driver.manager.local.ChromeManager;
import com.automation.driver.manager.local.EdgeManager;
import com.automation.driver.manager.local.FirefoxManager;
import com.automation.enums.BrowserType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LocalDriverFactory {

    public static WebDriver getDriver(BrowserType browserType) {
        return isChromeBrowser(browserType) ? new ChromeManager().getDriver() :
                isFirefoxBrowser(browserType) ? new FirefoxManager().getDriver() :
                        new EdgeManager().getDriver();
    }

    private static boolean isChromeBrowser(BrowserType browserType) {
        return browserType == BrowserType.CHROME;
    }

    private static boolean isFirefoxBrowser(BrowserType browserType) {
        return browserType == BrowserType.FIREFOX;
    }

}
