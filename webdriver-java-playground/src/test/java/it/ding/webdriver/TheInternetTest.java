package it.ding.webdriver;

import static it.ding.webdriver.DriverFactory.getDriver;
import static it.ding.webdriver.data.CommonData.validUser;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import it.ding.webdriver.pageobject.TheInternetLoginPage;
import org.junit.Test;

public class TheInternetTest extends Base {

    private TheInternetLoginPage loginPage = new TheInternetLoginPage(getDriver());

    @Test
    public void canLoginToTheInternet() {
        loginPage.visit();
        loginPage.login(validUser());

        assertThat(loginPage.getConfirmationText(),
            containsString("You logged into a secure area!"));
    }
}
