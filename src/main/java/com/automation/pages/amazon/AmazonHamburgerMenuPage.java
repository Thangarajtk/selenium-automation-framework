package com.automation.pages.amazon;

import com.automation.pages.base.BasePage;
import org.openqa.selenium.By;
import com.automation.enums.WaitStrategy;
import com.automation.utils.dynamicselector.DynamicXpathUtils;

public final class AmazonHamburgerMenuPage extends BasePage {

	private String linkComputers = "//div[text()='Mobiles, Computers']/parent::a";
	private String linkSubMenu = "//a[text()='%s']";

	public AmazonHamburgerMenuPage clickComputer() {
		click(By.xpath(linkComputers), WaitStrategy.CLICKABLE, "Mobiles and Computers");
		return this;
	}

	public AmazonLaptopPage clickOnSubMenuItem(String menutext) {
		click(By.xpath(DynamicXpathUtils.getXpath(linkSubMenu, menutext)), WaitStrategy.CLICKABLE, menutext);
		if(menutext.contains("Laptops")) {
			return new AmazonLaptopPage();
		}
		return null;
	}
}
