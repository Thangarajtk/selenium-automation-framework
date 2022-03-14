package com.automation.driver.factory;

import com.automation.config.ConfigFactory;
import com.automation.driver.localdriver.ChromeManager;
import com.automation.driver.localdriver.EdgeManager;
import com.automation.driver.localdriver.FirefoxManager;
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

        RunType runMode = ConfigFactory.getConfig().run_mode();

        switch (browser) {
            case CHROME:
                if (runMode == RunType.REMOTE) {
                    return new RemoteDriverManager().getDriver(browser, version);
                } else {
                    return new ChromeManager().getDriver();
                }
            case FIREFOX:
                if (runMode == RunType.REMOTE) {
                    return new RemoteDriverManager().getDriver(browser, version);
                } else {
                    return new FirefoxManager().getDriver();
                }
            case EDGE:
                if (runMode == RunType.REMOTE) {
                    return new RemoteDriverManager().getDriver(browser, version);
                } else {
                    return new EdgeManager().getDriver();
                }
            default:
                throw new BrowserInvocationFailedException("Browser type " + browser + " is not found. Please check the browser name");
        }
    }
}
