package com.automation.pages.orangehrm.pagecomponents.adduserspage;

import com.automation.enums.WaitStrategy;
import com.automation.pages.base.BasePage;
import org.openqa.selenium.By;

public class AddUserComponent extends BasePage {

    private static final By DROP_DOWN_USER_ROLE = By.xpath("//label[text()='User Role']/following-sibling::select");
    private static final By DROP_DOWN_STATUS = By.xpath("//label[text()='Status']/following-sibling::select");
    private static final By TEXT_BOX_EMPLOYEE_NAME = By.xpath("//label[text()='Employee Name']/following-sibling::input");
    private static final By TEXT_BOX_USER_NAME = By.xpath("//label[text()='Username']/following-sibling::input");
    private static final By TEXT_BOX_PASSWORD = By.xpath("//label[text()='Password']/following-sibling::input");
    private static final By TEXT_BOX_CONFIRM_PASSWORD = By.xpath("//label[text()='Confirm Password']/following-sibling::input");

    public AddUserComponent setUserRoleDropDown(String userRole) {
        select(DROP_DOWN_USER_ROLE, e -> e.selectByVisibleText(userRole));
        return this;
    }

    public AddUserComponent setStatusDropDown(String status) {
        select(DROP_DOWN_STATUS, e -> e.selectByVisibleText(status));
        return this;
    }

    public AddUserComponent setEmployeeNameTextBox(String employeeName) {
        sendKeys(TEXT_BOX_EMPLOYEE_NAME, employeeName, WaitStrategy.VISIBLE, "Employee name");
        return this;
    }

    public AddUserComponent setUserNameTextBox(String userName) {
        sendKeys(TEXT_BOX_USER_NAME, userName, WaitStrategy.VISIBLE, "Username");
        return this;
    }

    public AddUserComponent setPasswordTextBox(String password) {
        sendKeys(TEXT_BOX_PASSWORD, password, WaitStrategy.VISIBLE, "Password");
        return this;
    }

    public AddUserComponent setConfirmPasswordTextBox(String password) {
        sendKeys(TEXT_BOX_CONFIRM_PASSWORD, password, WaitStrategy.VISIBLE, "Confirm Password");
        return this;
    }

    public boolean isSuccessMessageDisplayed() {
        return true;
    }

    public boolean fillDetails() {
        return true;
    }

}
