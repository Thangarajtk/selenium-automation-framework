package com.automation.driver.manager.remote.seleniumgrid;

import com.automation.config.ConfigFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SeleniumGridFirefoxManager {

    @SneakyThrows
    public static WebDriver getDriver() {
        return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridUrl(), new FirefoxOptions());
    }
}
