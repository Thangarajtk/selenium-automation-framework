package com.automation.driver.manager.local;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FirefoxManager {

    public static WebDriver getDriver() {
        return new FirefoxDriver();
    }
}
