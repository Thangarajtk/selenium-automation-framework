package com.automation.driver.localdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeManager implements IDriver {

    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
