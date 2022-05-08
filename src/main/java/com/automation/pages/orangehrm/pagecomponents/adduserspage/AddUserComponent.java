package com.automation.pages.orangehrm.pagecomponents.adduserspage;

import com.automation.enums.WaitStrategy;
import com.automation.pages.base.BasePage;
import org.openqa.selenium.By;

public class AddUserComponent extends BasePage {

    private static final By BUTTON_ADD = By.id("btnAdd");

    public AddUserComponent setAddButton() {
        click(BUTTON_ADD, WaitStrategy.PRESENCE, "Add button");
        return this;
    }
}
