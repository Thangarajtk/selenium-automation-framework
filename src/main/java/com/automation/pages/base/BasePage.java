package com.automation.pages.base;

import com.automation.factories.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.automation.driver.manager.DriverManager;
import com.automation.enums.WaitStrategy;
import com.automation.reports.ExtentLogger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    protected void select(By by, Consumer<Select> consumer) {
        consumer.accept(new Select(DriverManager.getDriver().findElement(by)));
    }

    protected void clickOnMenuItemWithMatchingText(List<WebElement> elementList, String menuItem) {
        elementList.stream()
                .parallel()
                .filter(e -> e.getText().equalsIgnoreCase(menuItem))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element with text - " + menuItem + " is not present"))
                .click();
    }

    protected boolean checkForMatchingOptionInDropdown(By by, String option) {
        Select select = new Select(DriverManager.getDriver().findElement(by));

        return select.getOptions()
                .stream()
                .anyMatch(e -> e.getText().equalsIgnoreCase(option));
    }

    protected List<String> getAllText(By by) {
        List<WebElement> elementList = DriverManager.getDriver().findElements(by);

        return elementList.stream()
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }

    protected List<String> getAllMatchingText(By by, String matchingText) {
        List<WebElement> elementList = DriverManager.getDriver().findElements(by);

        return elementList.stream()
                .filter(e -> e.getText().contains(matchingText))
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }

    protected String getAttribute(By by, Function<WebElement, String> attributeFunction) {
        return attributeFunction.apply(DriverManager.getDriver().findElement(by));
    }

    protected boolean isPresent(By by, Predicate<WebElement> elementPredicate) {
        return elementPredicate.test(DriverManager.getDriver().findElement(by));
    }
}
