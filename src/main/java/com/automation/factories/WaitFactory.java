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
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import static com.automation.enums.WaitStrategy.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WaitFactory {

	private static final Map<WaitStrategy, Function<By, WebElement>> WAIT_FOR_ELEMENT_LOCATED_BY_FUNCTION_MAP =
		new EnumMap<>(WaitStrategy.class);

	private static final Function<By, WebElement> CLICKABLE_ELEMENT_BY = by ->
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT))
			.until(ExpectedConditions.elementToBeClickable(by));
	private static final Function<By, WebElement> PRESENCE_OF_ELEMENT_BY = by ->
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT))
			.until(ExpectedConditions.presenceOfElementLocated(by));
	private static final Function<By, WebElement> VISIBILITY_OF_ELEMENT_BY = by ->
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT))
			.until(ExpectedConditions.visibilityOfElementLocated(by));
	private static final Function<By, WebElement> NO_MATCH_BY = by -> DriverManager.getDriver().findElement(by);

	static {
		WAIT_FOR_ELEMENT_LOCATED_BY_FUNCTION_MAP.put(CLICKABLE, CLICKABLE_ELEMENT_BY);
		WAIT_FOR_ELEMENT_LOCATED_BY_FUNCTION_MAP.put(PRESENCE, PRESENCE_OF_ELEMENT_BY);
		WAIT_FOR_ELEMENT_LOCATED_BY_FUNCTION_MAP.put(VISIBLE, VISIBILITY_OF_ELEMENT_BY);
		WAIT_FOR_ELEMENT_LOCATED_BY_FUNCTION_MAP.put(NONE, NO_MATCH_BY);
	}

	public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
		return WAIT_FOR_ELEMENT_LOCATED_BY_FUNCTION_MAP.get(waitstrategy).apply(by);
	}

}
