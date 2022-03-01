package com.automation.factories;

import com.automation.config.ConfigFactory;
import com.automation.enums.BrowserType;
import com.automation.enums.ConfigJson;
import com.automation.exceptions.BrowserInvocationFailedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.automation.utils.configloader.JsonUtils.get;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {

    public static WebDriver getDriver(BrowserType browser, String version) throws MalformedURLException {

        String runMode = ConfigFactory.getConfig().runmode();

        switch (browser) {
            case CHROME:
                if (runMode.equalsIgnoreCase("remote")) {
                    ChromeOptions browserOptions = new ChromeOptions();
                    browserOptions.setBrowserVersion(version);
                    return new RemoteWebDriver(new URL(get(ConfigJson.URL)), browserOptions);
                } else {
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                }
            case FIREFOX:
                if (runMode.equalsIgnoreCase("remote")) {
                    FirefoxOptions browserOptions = new FirefoxOptions();
                    browserOptions.setBrowserVersion(version);
                    return new RemoteWebDriver(new URL(get(ConfigJson.URL)), browserOptions);
                } else {
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                }
            case EDGE:
                if (runMode.equalsIgnoreCase("remote")) {
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName(String.valueOf(BrowserType.EDGE));
                    cap.setVersion(version);
                    return new RemoteWebDriver(new URL(get(ConfigJson.URL)), cap);
                } else {
                    WebDriverManager.edgedriver().setup();
                    return new EdgeDriver();
                }
            default:
                throw new BrowserInvocationFailedException("Browser type " + browser + " is not found. Please check the browser name");
        }
    }
}
