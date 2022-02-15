package com.automation.factories;

import com.automation.enums.BrowserType;
import com.automation.enums.ConfigJson;
import com.automation.enums.ConfigProperties;
import com.automation.exceptions.BrowserInvocationFailedException;
import static com.automation.utils.configloader.JsonUtils.*;
import com.automation.utils.configloader.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {

    public static WebDriver getDriver(BrowserType browser, String version) throws MalformedURLException {

        String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);

        switch (browser) {
            case CHROME:
                if (runmode.equalsIgnoreCase("remote")) {
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName(String.valueOf(BrowserType.CHROME));
                    cap.setVersion(version);
                    return new RemoteWebDriver(new URL(get(ConfigJson.URL)), cap);
                } else {
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                }
            case FIREFOX:
                if (runmode.equalsIgnoreCase("remote")) {
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName(String.valueOf(BrowserType.FIREFOX));
                    cap.setVersion(version);
                    return new RemoteWebDriver(new URL(get(ConfigJson.URL)), cap);
                } else {
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                }
            case EDGE:
                if (runmode.equalsIgnoreCase("remote")) {
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