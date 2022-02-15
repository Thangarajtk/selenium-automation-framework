package com.automation.driver;

import java.util.Objects;

import com.automation.enums.BrowserType;
import com.automation.factories.DriverFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import com.automation.enums.ConfigProperties;
import com.automation.utils.configloader.PropertyUtils;

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
		DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
