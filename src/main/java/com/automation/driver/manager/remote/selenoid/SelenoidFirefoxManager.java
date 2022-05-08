package com.automation.driver.manager.remote.selenoid;

import com.automation.config.ConfigFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SelenoidFirefoxManager {

    @SneakyThrows
    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("browserVersion", "99.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        return new RemoteWebDriver(ConfigFactory.getConfig()
                .selenoidUrl(), capabilities);
    }
}
