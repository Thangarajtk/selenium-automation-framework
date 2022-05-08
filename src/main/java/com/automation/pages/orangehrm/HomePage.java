package com.automation.pages.orangehrm;

import com.automation.pages.base.BasePage;
import com.automation.pages.orangehrm.enums.topmenucomponent.MenuType;
import com.automation.pages.orangehrm.enums.topmenucomponent.SubMenuType;
import com.automation.pages.orangehrm.pagecomponents.homepage.TopMenuComponent;
import org.openqa.selenium.By;
import com.automation.enums.WaitStrategy;

public final class HomePage extends BasePage {
	
	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");

	private final TopMenuComponent topMenuComponent;

	public TopMenuComponent getTopMenuComponent() {
		return topMenuComponent;
	}

	public HomePage() {
		this.topMenuComponent = new TopMenuComponent();
	}

	public SystemUsersPage navigateToAddUsersPage() {
		topMenuComponent.clickMenuItem(MenuType.ADMIN)
				.clickSubMenuItem(SubMenuType.USER_MANAGEMENT)
				.clickSubMenuItem(SubMenuType.USERS);

		return new SystemUsersPage();
	}

	public HomePage clickWelcome() {
		click(linkWelcome, WaitStrategy.PRESENCE, "Welcome link");
		return this;
	}

	public LoginPage clickLogout() {
		click(linkLogout, WaitStrategy.CLICKABLE, "Logout button");
		return new LoginPage();
	}
}
