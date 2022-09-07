package com.automation.pages.orangehrm.pagecomponents.homepage;

import com.automation.enums.WaitStrategy;
import com.automation.pages.base.BasePage;
import com.automation.pages.orangehrm.enums.topmenucomponent.MenuType;
import com.automation.pages.orangehrm.enums.topmenucomponent.SubMenuType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuComponent extends BasePage {

    private static final String MENU = "//b[text()='%s']/parent::a";
    private static final By LOGO = By.xpath("//img[@alt='OrangeHRM']");
    private static final By LINK_MARKET_PLACE = By.id("MP_LINK");

    public TopMenuComponent clickMenuItem(MenuType menuType) {
        String xpath = String.format(MENU, menuType);
        click(By.xpath(xpath), WaitStrategy.PRESENCE, menuType.toString());
        return this;
    }

    public TopMenuComponent clickSubMenuItem(SubMenuType subMenuType) {
        String xpath = String.format(MENU, subMenuType);
        click(By.xpath(xpath), WaitStrategy.PRESENCE, subMenuType.toString());
        return this;
    }

    public String getLogoSourceString() {
        return getAttribute(LOGO, e -> e.getAttribute("src"));
    }

    public boolean isMarketPlaceLinkPresent() {
        return isPresent(LINK_MARKET_PLACE, WebElement::isDisplayed);
    }
}
