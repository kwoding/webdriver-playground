package it.ding.webdriver;

import static it.ding.webdriver.data.CommonData.validUser;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import it.ding.webdriver.pageobject.TheInternetLoginPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TheInternetTest extends Base {

    private TheInternetLoginPage loginPage = new TheInternetLoginPage(driver);

    @Test
    public void canLoginToTheInternet() throws InterruptedException {
        loginPage.visit();
        loginPage.login(validUser());

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".message"), "text"));

        assertThat(loginPage.getConfirmationText(),
            containsString("You logged into a secure area!"));
    }
}
