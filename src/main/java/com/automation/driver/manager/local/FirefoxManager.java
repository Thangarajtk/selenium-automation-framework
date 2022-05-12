package com.automation.driver.manager.local;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class FirefoxManager {

    public static WebDriver getDriver() {
        return WebDriverManager.firefoxdriver().create();
    }
}
