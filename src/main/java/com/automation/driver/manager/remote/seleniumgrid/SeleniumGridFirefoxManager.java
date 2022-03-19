package com.automation.driver.manager.remote.seleniumgrid;

import com.automation.driver.manager.IDriver;
import com.automation.enums.ConfigJson;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static com.automation.utils.configloader.JsonUtils.get;

public class SeleniumGridFirefoxManager implements IDriver {

    @SneakyThrows
    @Override
    public WebDriver getDriver() {
        return new RemoteWebDriver(new URL(get(ConfigJson.URL)), new FirefoxOptions());
    }
}
