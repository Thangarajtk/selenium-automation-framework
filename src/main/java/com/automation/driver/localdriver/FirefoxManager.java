package com.automation.driver.localdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxManager implements IDriver {

    @Override
    public WebDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
