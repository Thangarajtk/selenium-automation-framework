package com.automation.driver.manager.local;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class EdgeManager {

    public static WebDriver getDriver() {
        return WebDriverManager.edgedriver().create();
    }
}
