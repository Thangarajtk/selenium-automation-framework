package com.automation.pages.amazon;

import com.automation.constants.StringConstants;
import com.automation.pages.base.BasePage;
import org.openqa.selenium.By;
import com.automation.enums.WaitStrategy;
import com.automation.utils.dynamicselector.DynamicXpathUtils;

public final class AmazonHamburgerMenuPage extends BasePage {

	private final String linkComputers = "//div[text()='Mobiles, Computers']/parent::a";
	private final String linkSubMenu = "//a[text()='%s']";

	public AmazonHamburgerMenuPage clickComputer() {
		click(By.xpath(linkComputers), WaitStrategy.CLICKABLE, "Mobiles and Computers");
		return this;
	}

	public AmazonLaptopPage clickOnSubMenuItem(String menuItem) {
		click(By.xpath(DynamicXpathUtils.getXpath(linkSubMenu, menuItem)), WaitStrategy.CLICKABLE, menuItem);
		if(menuItem.contains(StringConstants.SELECTED_MENU_ITEM)) {
			return new AmazonLaptopPage();
		}
		return null;
	}
}
