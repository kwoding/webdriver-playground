package it.ding.webdriver;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private static RemoteWebDriver driver;

    private DriverFactory() {
    }

    static void setDriver(Platform platform) {
        switch (platform) {
            case FIREFOX_LOCAL:
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver();
                break;
            case CHROME_LOCAL:
            default:
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                driver = new ChromeDriver();
                break;
        }
    }

    public static RemoteWebDriver getDriver() {
        return driver;
    }
}
