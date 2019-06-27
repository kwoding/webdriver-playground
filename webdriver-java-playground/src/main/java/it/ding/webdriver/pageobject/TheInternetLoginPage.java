package it.ding.webdriver.pageobject;

import it.ding.webdriver.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TheInternetLoginPage extends BasePage {

    private static final String LOGIN_URL = "http://the-internet.herokuapp.com/login";
    private static final By USERNAME = By.cssSelector("#username");
    private static final By PASSWORD = By.cssSelector("#password");
    private static final By SUBMIT = By.cssSelector("button[type=\"submit\"]");
    private static final By CONFIRMATION_TEXT = By.cssSelector(".success");

    public TheInternetLoginPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void visit() {
        visit(LOGIN_URL);
    }

    public void login(User user) {
        type(USERNAME, user.getUsername());
        type(PASSWORD, user.getPassword());
        click(SUBMIT);
    }

    public String getConfirmationText() {
        isDisplayed(CONFIRMATION_TEXT);
        return getText(CONFIRMATION_TEXT);
    }

    public WebElement getSubmitButton() {
        isDisplayed(SUBMIT);
        return find(SUBMIT);
    }
}
