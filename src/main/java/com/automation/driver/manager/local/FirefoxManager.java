package com.automation.driver.manager.local;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FirefoxManager {

    public static WebDriver getDriver() {
        return WebDriverManager.firefoxdriver().create();
    }
}
