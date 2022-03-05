package com.automation.driver.remotedriver;

import com.automation.enums.BrowserType;
import com.automation.enums.ConfigJson;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import static com.automation.utils.configloader.JsonUtils.get;

public class RemoteDriverManager implements IRemoteDriver {

    @SneakyThrows
    @Override
    public WebDriver getDriver(BrowserType browserName, String browserVersion) {
        if (browserName == BrowserType.CHROME) {
            return new RemoteWebDriver(new URL(get(ConfigJson.URL)), new ChromeOptions());
        }
        else if (browserName == BrowserType.EDGE) {
            return new RemoteWebDriver(new URL(get(ConfigJson.URL)), new EdgeOptions());
        }
        else {
            return new RemoteWebDriver(new URL(get(ConfigJson.URL)), new FirefoxOptions());
        }
    }
}
