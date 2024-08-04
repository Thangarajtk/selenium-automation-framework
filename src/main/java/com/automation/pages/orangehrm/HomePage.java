package com.automation.pages.orangehrm;

import com.automation.pages.base.BasePage;
import com.automation.pages.orangehrm.enums.topmenucomponent.MenuType;
import com.automation.pages.orangehrm.enums.topmenucomponent.SubMenuType;
import com.automation.pages.orangehrm.pagecomponents.homepage.TopMenuComponent;
import com.automation.pages.orangehrm.validator.HomePageValidator;
import lombok.Getter;
import org.openqa.selenium.By;
import com.automation.enums.WaitStrategy;
import org.openqa.selenium.WebElement;

public final class HomePage extends BasePage {
	
	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");
	private static final By HEADER = By.xpath("//h1");

	@Getter
	private final TopMenuComponent topMenuComponent;

	public HomePage() {
		this.topMenuComponent = new TopMenuComponent();
	}

	public SystemUsersPage navigateToSystemUsersPage() {
		topMenuComponent.clickMenuItem(MenuType.ADMIN)
				.clickSubMenuItem(SubMenuType.USER_MANAGEMENT)
				.clickSubMenuItem(SubMenuType.USERS);

		return new SystemUsersPage();
	}

	public HomePageValidator getHomePageValidator() {
		return HomePageValidator.builder()
				.isMarketPlaceLinkPresent(topMenuComponent.isMarketPlaceLinkPresent())
				.logoSourceText(topMenuComponent.getLogoSourceString())
				.headerName(getAttribute(HEADER, WebElement::getText))
				.build();
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
