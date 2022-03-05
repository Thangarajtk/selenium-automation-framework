package com.automation.driver.remotedriver;

import com.automation.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public interface IRemoteDriver {

    WebDriver getDriver(BrowserType browserName, String browserVersion);
}
