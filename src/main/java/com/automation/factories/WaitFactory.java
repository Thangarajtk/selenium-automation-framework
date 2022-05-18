package com.automation.factories;

import com.automation.constants.FrameworkConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.driver.manager.DriverManager;
import com.automation.enums.WaitStrategy;

import java.time.Duration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WaitFactory {

	public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {

		switch (waitstrategy) {
			case CLICKABLE:
				return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT))
						.until(ExpectedConditions.elementToBeClickable(by));
			case PRESENCE:
				return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT))
						.until(ExpectedConditions.presenceOfElementLocated(by));
			case VISIBLE:
				return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT))
						.until(ExpectedConditions.visibilityOfElementLocated(by));
			case NONE:
				return DriverManager.getDriver().findElement(by);
		}
		return null;
	}

}
