package com.automation.driver.manager.local;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EdgeManager {

    public static WebDriver getDriver() {
        return new EdgeDriver();
    }
}
