package it.ding.webdriver.util;

import static it.ding.webdriver.DriverFactory.getDriver;

import org.openqa.selenium.Dimension;

public class BrowserUtil {

    private BrowserUtil() {
    }

    static void refreshPage() {
        getDriver().navigate().refresh();
    }

    static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    static void resizeBrowser(int width, int height) {
        Dimension dimension = new Dimension(width,height);
        getDriver().manage().window().setSize(dimension);
    }
}
