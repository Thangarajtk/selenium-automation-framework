package com.automation.driver.manager.local;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChromeManager {

    public static WebDriver getDriver() {
        return WebDriverManager.chromedriver().create();
    }
}
