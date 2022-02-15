package com.automation.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.automation.base.BaseTest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.automation.driver.DriverManager;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GooglepageTests extends BaseTest {

	@Test
	public void googleSearchTest() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();

		assertThat(title)
			.as("Object is actually null").isNotNull()
			.as("It does not contains expected text").containsIgnoringCase("google search")
			.matches("\\w.*"+"Google Search")
			.hasSizeBetween(15, 100);
	}

}
