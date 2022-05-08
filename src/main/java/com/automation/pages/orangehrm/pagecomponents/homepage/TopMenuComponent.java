package com.automation.pages.orangehrm.pagecomponents.homepage;

import com.automation.enums.WaitStrategy;
import com.automation.pages.base.BasePage;
import com.automation.pages.orangehrm.enums.topmenucomponent.MenuType;
import com.automation.pages.orangehrm.enums.topmenucomponent.SubMenuType;
import org.openqa.selenium.By;

public class TopMenuComponent extends BasePage {

    private static final String MENU = "//b[text()='%s']/parent::a";

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
}
