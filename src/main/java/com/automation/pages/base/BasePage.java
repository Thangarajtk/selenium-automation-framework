package com.automation.pages.base;

import com.automation.factories.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.automation.driver.DriverManager;
import com.automation.enums.WaitStrategy;
import com.automation.reports.ExtentLogger;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected void click(By by, WaitStrategy waitstrategy, String elementName) {
        WebElement element = WaitFactory.performExplicitWait(waitstrategy, by);
        element.click();
        ExtentLogger.pass(elementName + " is clicked");
    }

    protected void sendKeys(By by, String value, WaitStrategy waitstrategy, String elementName) {
        WebElement element = WaitFactory.performExplicitWait(waitstrategy, by);
        element.sendKeys(value);
        ExtentLogger.pass(value + " is entered successfully in " + elementName);
    }

    protected void sendKeysAndPressEnter(By by, String value, WaitStrategy waitstrategy, String elementName) {
        try {
            WebElement element = WaitFactory.performExplicitWait(waitstrategy, by);
            element.sendKeys(value, Keys.ENTER);
            ExtentLogger.pass("Entered value - <b>" + value + "</b> in the field " + elementName + " and pressed enter");
        } catch (Exception e) {
            ExtentLogger.fail("Exception caught while entering value", e);
        }
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }


}
