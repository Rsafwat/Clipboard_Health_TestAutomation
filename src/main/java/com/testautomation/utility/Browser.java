package com.testautomation.utility;

import java.util.ArrayList;
import java.util.Properties;
import com.testautomation.reports.ExtentReportChrome;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

/**
 * The Class Browser.
 */
public abstract class Browser {


    private static Properties propertiesFile;
    /**
     * The chrome report.
     */
    private static ExtentReportChrome report;
    static {
        try {
            propertiesFile = new PropertiesFileReader().getPropertiesFile();
            System.out.println("INFO: ENV file loaded successfully.");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Switch tabs.
     *
     * @param driver         the driver
     * @param switchToWindow the switch to window
     */
    public static void switchTabs(
        final WebDriver driver,
        final int switchToWindow
    ) {
        final ArrayList<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(switchToWindow));
    }

    /**
     * Gets the current tab.
     *
     * @param driver the driver
     * @return the current tab
     */
    public static int getCurrentTab(final WebDriver driver) {

        final String currentTab = driver.getWindowHandle();
        final ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        tabs.indexOf(currentTab);
        return tabs.indexOf(currentTab);

    }

    /**
     * Change window dimension.
     *
     * @param driver the driver
     * @param width  the browser window width
     * @param height the browser window height
     */
    public static void changeWindowDimension(
        final WebDriver driver,

        final int width,
        final int height
    ) {

        final Dimension dm = new Dimension(width, height);
        driver.manage().window().setSize(dm);
    }

    /**
     * method to switch to parent iframe.
     *
     * @param driver the driver
     * @throws InterruptedException
     */
    public static void switchToParentIframe(final WebDriver driver) throws InterruptedException {
        driver.switchTo().parentFrame();

    }

    /**
     * Refresh page.
     *
     * @param driver the driver
     */
    public static void refreshPage(final WebDriver driver) {
        final String currentUrl = driver.getCurrentUrl();
        driver.get(currentUrl);
        driver.navigate().refresh();
    }
    /**
     * Get the chrome extent report.
     *
     * @return extent report
     */
    public static ExtentReportChrome getReport() {
        return report;
    }

    /**
     * Set the chrome extent report.
     *
     * @param eReport extent report
     */
    public static void setReport(final ExtentReportChrome eReport) {
        Browser.report = eReport;
    }
    /**
     *
     * @return properties file
     */
    public static Properties getPropertiesFile() {
        return propertiesFile;
    }
}
