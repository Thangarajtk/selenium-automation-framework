package com.automation.driver.manager.remote.seleniumgrid;

import com.automation.config.ConfigFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridChromeManager {

    @SneakyThrows
    public static WebDriver getDriver() {
        return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridUrl(), new ChromeOptions());
    }
}
