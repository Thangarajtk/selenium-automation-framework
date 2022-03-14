package com.automation.driver.factory;

import com.automation.driver.localdriver.ChromeManager;
import com.automation.driver.localdriver.EdgeManager;
import com.automation.driver.localdriver.FirefoxManager;
import com.automation.enums.BrowserType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LocalDriverFactory {

    public static WebDriver getDriver(BrowserType browserType) {
        WebDriver driver = (isChromeBrowser(browserType)) ? new ChromeManager().getDriver() :
                (isFirefoxBrowser(browserType)) ?
                        new FirefoxManager().getDriver() : new EdgeManager().getDriver();

        return driver;
    }

    static boolean isChromeBrowser(BrowserType browserType) {
        return browserType == BrowserType.CHROME;
    }

    static boolean isFirefoxBrowser(BrowserType browserType) {
        return browserType == BrowserType.FIREFOX;
    }

}
