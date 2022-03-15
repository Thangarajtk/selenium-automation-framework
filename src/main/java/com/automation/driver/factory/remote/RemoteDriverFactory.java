package com.automation.driver.factory.remote;

import com.automation.driver.manager.remote.RemoteChromeManager;
import com.automation.driver.manager.remote.RemoteEdgeManager;
import com.automation.driver.manager.remote.RemoteFirefoxManager;
import com.automation.enums.BrowserType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RemoteDriverFactory {

    public static WebDriver getDriver(BrowserType browserType) {
        WebDriver driver = (isChromeBrowser(browserType)) ? new RemoteChromeManager().getDriver() :
                (isFirefoxBrowser(browserType)) ?
                        new RemoteFirefoxManager().getDriver() : new RemoteEdgeManager().getDriver();

        return driver;
    }

    static boolean isChromeBrowser(BrowserType browserType) {
        return browserType == BrowserType.CHROME;
    }

    static boolean isFirefoxBrowser(BrowserType browserType) {
        return browserType == BrowserType.FIREFOX;
    }

}
