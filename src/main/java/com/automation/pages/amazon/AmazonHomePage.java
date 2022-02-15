package com.automation.pages.amazon;

import com.automation.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class AmazonHomePage extends BasePage {

	@FindBy(id="nav-hamburger-menu") 
	private WebElement linkHamburger;
	
	public AmazonHamburgerMenuPage clickHamburger() {
		linkHamburger.click();
		return new AmazonHamburgerMenuPage();
	}
}
