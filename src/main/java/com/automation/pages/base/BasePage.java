package com.automation.pages.base;

import com.automation.factories.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.automation.driver.DriverManager;
import com.automation.enums.WaitStrategy;
import com.automation.reports.ExtentLogger;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected void click(By by, WaitStrategy waitstrategy, String elementname) {
        WebElement element = WaitFactory.performExplicitWait(waitstrategy, by);
        element.click();
        ExtentLogger.pass(elementname + " is clicked");
    }

    protected void sendKeys(By by, String value, WaitStrategy waitstrategy, String elementname) {
        WebElement element = WaitFactory.performExplicitWait(waitstrategy, by);
        element.sendKeys(value);
        ExtentLogger.pass(value + " is entered successfully in " + elementname);
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }


}
