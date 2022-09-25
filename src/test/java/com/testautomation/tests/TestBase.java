package com.testautomation.tests;

import java.io.IOException;
import java.util.Properties;

import com.testautomation.utility.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.testautomation.reports.ExtentReportChrome;
import com.testautomation.utility.PropertiesFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * All beforeSuite, afterSuite, beforeTest, and afterTest methods should be
 * implemented here. Those should only exist once.
 *
 * beforeSuite/afterSuite: runs before/after all classes listed in test tag in
 * testng xml test suite file.beforeTest/afterTest: runs before/after all
 * methods in all classes listed in test tag in testng xml test suite file.
 */
public abstract class  TestBase {

    /** The chrome report. */
    private static ExtentReportChrome chromeReport;
    /** The driver. */
    private static WebDriver driver;



    /** The properties. */
    private static Properties properties;

    /**
     * Sets the up.
     ** @throws IOException Signals that an I/O exception has occurred.
     * @BeforeSuite this initialization method for setting up the driver should be
     *              implemented before any test.
     */

    @BeforeSuite
    public void setUp() throws IOException {
        final Properties properties = new PropertiesFileReader().getPropertiesFile();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("base.url"));
    }

    /**
     * shared BeforeClass that acquires a driver.
     *
     * @throws Throwable the throwable
     */
    @BeforeClass
    public void beforeClass() throws Throwable {

    }


    /**
     * This is a shared AfterClass method. It's mandatory to all test classes. It
     * reset the current thread diver.
     *
     */
    @AfterClass
    public void afterClass() {
        driver.close();
    }

    /**
     * After suite.
     */
    @AfterSuite
    public void afterSuite() {
        driver.quit();

    }
    /**
     * This is a shared beforeMethod method. It's mandatory to all test classes. It
     * gets create test class name.
     *
     * If you want to add more functionality, add it to the class you want to extend
     * the functionality in, call the super.afterMethod() method. Then add your
     * additional code.
     *
     * @param result the result
     */
    @BeforeMethod
    public void handleTestClassName(final ITestResult result)
    {
        Browser.getReport().CreateTestStart(result.getTestClass().getName());
    }
    /**
     * This is a shared AfterMethod method. It's mandatory to all test classes. It
     * takes a screenshot for the current state.
     *
     * If you want to add more functionality, add it to the class you want to extend
     * the functionality in, call the super.afterMethod() method. Then add your
     * additional code.
     *
     * @param result the result
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @AfterMethod
    public void afterMethod(final ITestResult result) throws IOException {
        if (result.getStatus() == result.FAILURE) {
            Browser.getReport()
                .takeScreenShot(
                    getDriver(),
                    Browser.getReport().getScreenshotFileName(result, "")
                );
        }
    }



    /**
     * Gets the web driver.
     *
     * @return the web driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Sets the driver.
     *
     * @param newDriver the new driver
     */
    public void setDriver(final WebDriver newDriver) {
        driver = newDriver;
    }

}
