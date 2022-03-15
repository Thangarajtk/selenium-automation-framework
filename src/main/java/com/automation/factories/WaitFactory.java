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
		WebElement element = null;
		switch (waitstrategy) {
			case CLICKABLE:
				element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
						.until(ExpectedConditions.elementToBeClickable(by));
				break;
			case PRESENCE:
				element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
						.until(ExpectedConditions.presenceOfElementLocated(by));
				break;
			case VISIBLE:
				element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
						.until(ExpectedConditions.visibilityOfElementLocated(by));
				break;
			case NONE:
				element = DriverManager.getDriver().findElement(by);
				break;
		}
		return element;
	}

}
