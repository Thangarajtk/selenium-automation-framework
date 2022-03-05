package com.automation.driver.factory;

import com.automation.config.ConfigFactory;
import com.automation.driver.localdriver.ChromeDriverManager;
import com.automation.driver.localdriver.EdgeDriverManager;
import com.automation.driver.localdriver.FirefoxDriverManager;
import com.automation.driver.remotedriver.RemoteDriverManager;
import com.automation.enums.BrowserType;
import com.automation.enums.RunType;
import com.automation.exceptions.BrowserInvocationFailedException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {

    public static WebDriver getDriver(BrowserType browser, String version) {

        RunType runMode = ConfigFactory.getConfig().runmode();

        switch (browser) {
            case CHROME:
                if (runMode == RunType.REMOTE) {
                    return new RemoteDriverManager().getDriver(browser, version);
                } else {
                    return new ChromeDriverManager().getDriver();
                }
            case FIREFOX:
                if (runMode == RunType.REMOTE) {
                    return new RemoteDriverManager().getDriver(browser, version);
                } else {
                    return new FirefoxDriverManager().getDriver();
                }
            case EDGE:
                if (runMode == RunType.REMOTE) {
                    return new RemoteDriverManager().getDriver(browser, version);
                } else {
                    return new EdgeDriverManager().getDriver();
                }
            default:
                throw new BrowserInvocationFailedException("Browser type " + browser + " is not found. Please check the browser name");
        }
    }
}
