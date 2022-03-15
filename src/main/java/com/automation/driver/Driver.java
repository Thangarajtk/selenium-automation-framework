package com.automation.driver;

import com.automation.config.ConfigFactory;
import com.automation.driver.manager.DriverManager;
import com.automation.enums.BrowserType;
import com.automation.driver.factory.DriverFactory;
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

	public static void initDriver(BrowserType browser) {
		if (Objects.isNull(DriverManager.getDriver())) {
			DriverManager.setDriver(DriverFactory.getDriver(browser));
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
