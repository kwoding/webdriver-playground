package it.ding.webdriver;

import static it.ding.webdriver.DriverFactory.getDriver;
import static it.ding.webdriver.DriverFactory.setDriver;
import static it.ding.webdriver.Platform.CHROME_LOCAL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {

    private static RemoteWebDriver driver;

    @BeforeClass
    public static void setUp() {
        setDriver(CHROME_LOCAL);
        driver = getDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
