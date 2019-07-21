package it.ding.webdriver.pageobject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

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
    private static final By ANOTHER_ELEMENT = By.xpath("/container/div[1]/title");
    private static final By YET_ANOTHER_ELEMENT = By.cssSelector(".container div div button");
    private static final By ANOTHER_BUTTON = By.tagName("div");

    public TheInternetLoginPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void visit() throws InterruptedException {
        Thread.sleep(3000);
        visit(LOGIN_URL);
        assertThat(getText(ANOTHER_ELEMENT),
            containsString("You logged into a secure area!"));
    }

    public void login(User user) {
        type(USERNAME, user.getUsername());
        type(PASSWORD, user.getPassword());
        click(SUBMIT);
    }

    public String getConfirmationText() {
        waitUntilDisplayed(CONFIRMATION_TEXT);
        return getText(CONFIRMATION_TEXT);
    }

    public WebElement getSubmitButton() {
        waitUntilDisplayed(SUBMIT);
        return find(SUBMIT);
    }
}
