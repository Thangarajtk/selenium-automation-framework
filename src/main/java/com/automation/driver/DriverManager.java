package com.automation.driver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

/**
 * DriverManager class helps to achieve thread safety for the instance.
 *
 * @author Administrator
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverManager {

	private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	public static void setDriver(WebDriver driver) {
		threadLocalDriver.set(driver);
	}
	
	public static void unload() {
		threadLocalDriver.remove();
	}
}
