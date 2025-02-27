package com.automation.pages.amazon;

import com.automation.enums.WaitStrategy;
import com.automation.pages.base.BasePage;
import org.openqa.selenium.By;

public final class AmazonHomePage extends BasePage {

    private final By menuHamburger = By.id("nav-hamburger-menu");

    public AmazonHamburgerMenuPage clickHamburger() {
        click(menuHamburger, WaitStrategy.CLICKABLE, "Hamburger menu");
        return new AmazonHamburgerMenuPage();
    }
}
