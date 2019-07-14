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

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void longPress(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(find(locator)).clickAndHold().perform();
    }

    public void type(By locator, String inputText) {
        find(locator).sendKeys(inputText);
    }

    public void select(String inputText, By locator) {
        Select selectItem = new Select(find(locator));
        selectItem.selectByVisibleText(inputText);
    }

    public void clear(By locator) {
        find(locator).clear();
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public void waitUntilDisplayed(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isDisplayed(By locator) {
        try {
            waitUntilDisplayed(locator);
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    public void waitUntilTextPresentInElement(By locator, String searchString) {
            WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, searchString));
    }

    public boolean isTextPresentInElement(By locator, String searchString) {
        try {
            waitUntilTextPresentInElement(locator, searchString);
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    public String getVisibleText(By locator) {
        return find(locator).getText();
    }

    public String getAttributeValue(By locator, String attribute) {
        return find(locator).getAttribute(attribute);
    }
}
