package com.automation.driver.localdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeManager implements IDriver {

    @Override
    public WebDriver getDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
