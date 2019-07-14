package it.ding.webdriver.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private RemoteWebDriver driver;

    private static final int TIMEOUT_IN_SECONDS = 3;

    BasePage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    void visit(String url) {
        driver.get(url);
    }

    WebElement find(By locator) {
        return driver.findElement(locator);
    }


    void click(By locator) {
        find(locator).click();
    }

    void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    void longPress(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(find(locator)).clickAndHold().perform();
    }

    void type(By locator, String inputText) {
        find(locator).sendKeys(inputText);
    }

    void select(String inputText, By locator) {
        Select selectItem = new Select(find(locator));
        selectItem.selectByVisibleText(inputText);
    }

    void clear(By locator) {
        find(locator).clear();
    }

    String getText(By locator) {
        return find(locator).getText();
    }

    void waitUntilDisplayed(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    boolean isDisplayed(By locator) {
        try {
            waitUntilDisplayed(locator);
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    void waitUntilTextPresentInElement(By locator, String searchString) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, searchString));
    }

    boolean isTextPresentInElement(By locator, String searchString) {
        try {
            waitUntilTextPresentInElement(locator, searchString);
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    String getVisibleText(By locator) {
        return find(locator).getText();
    }

    String getAttributeValue(By locator, String attribute) {
        return find(locator).getAttribute(attribute);
    }
}
