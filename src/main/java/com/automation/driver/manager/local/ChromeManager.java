package com.automation.driver.manager.local;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class ChromeManager {

    public static WebDriver getDriver() {
        return WebDriverManager.chromedriver().create();
    }
}
