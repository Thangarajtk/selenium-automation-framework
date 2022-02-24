package com.automation.driver;

import com.automation.config.ConfigFactory;
import com.automation.enums.BrowserType;
import com.automation.factories.DriverFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 *  Driver class is responsible for invoking and closing the browsers.
 *
 * It is also responsible for setting the driver variable to DriverManager which handles the thread safety for the webdriver instance.
 *
 * @author Administrator
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Driver {

	public static void initDriver(String browser, String version) throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			DriverManager.setDriver(DriverFactory.getDriver(BrowserType.valueOf(browser.toUpperCase()), version));
		}
		DriverManager.getDriver().get(ConfigFactory.getConfig().url());
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
