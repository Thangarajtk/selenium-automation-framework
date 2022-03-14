package com.automation.pages.orangehrm;

import com.automation.pages.base.BasePage;
import org.openqa.selenium.By;

import com.automation.enums.WaitStrategy;

public final class HomePage extends BasePage {
	
	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");

	public HomePage clickWelcome() {
		click(linkWelcome, WaitStrategy.PRESENCE, "Welcome link");
		return this;
	}

	public LoginPage clickLogout() {
		click(linkLogout, WaitStrategy.CLICKABLE, "Logout button");
		return new LoginPage();
	}
}