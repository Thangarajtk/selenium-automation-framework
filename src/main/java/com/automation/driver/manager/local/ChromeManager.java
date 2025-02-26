package com.automation.driver.manager.local;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChromeManager {

    public static WebDriver getDriver() {
        return new ChromeDriver();
    }
}
