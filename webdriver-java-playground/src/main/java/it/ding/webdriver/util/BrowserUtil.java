package it.ding.webdriver.util;

import static it.ding.webdriver.DriverFactory.getDriver;

import org.openqa.selenium.Dimension;

public class BrowserUtil {

    private BrowserUtil() {
    }

    public static void refreshPage() {
        getDriver().navigate().refresh();
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public static void resizeBrowser(int width, int height) {
        Dimension dimension = new Dimension(width,height);
        getDriver().manage().window().setSize(dimension);
    }
}
