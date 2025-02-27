package com.automation.pages.amazon;

import com.automation.constants.StringConstants;
import com.automation.factories.WaitFactory;
import com.automation.pages.base.BasePage;
import org.openqa.selenium.By;
import com.automation.enums.WaitStrategy;
import com.automation.utils.dynamicselector.DynamicXpathUtils;

public final class AmazonHamburgerMenuPage extends BasePage {

    private final By linkComputers = By.xpath("//div[text()='Mobiles, Computers']/parent::a");
    private String linkSubMenu = "//a[text()='%s']";

    public AmazonHamburgerMenuPage clickComputer() {
        WaitFactory.performExplicitWait(WaitStrategy.VISIBLE, linkComputers);
        click(linkComputers, WaitStrategy.CLICKABLE, "Mobiles and Computers");
        return this;
    }

    public AmazonLaptopPage clickOnSubMenuItem(String menuItem) {
        By findSubMenu = By.xpath(DynamicXpathUtils.getXpath(linkSubMenu, menuItem));
        WaitFactory.performExplicitWait(WaitStrategy.PRESENCE, findSubMenu);
        clickUsingJSExecutor(findSubMenu);

        return menuItem.contains(StringConstants.SELECTED_MENU_ITEM) ? new AmazonLaptopPage() : null;
    }
}
