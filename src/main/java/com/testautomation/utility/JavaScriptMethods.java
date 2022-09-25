package com.testautomation.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The Class JavaScriptUtils.
 */
public abstract class JavaScriptMethods {

    /**
     * click - method to execute a JavaScript click event.
     * @param driver  the driver
     * @param element the element
     */
    public static void click(
        final WebDriver driver,
        final WebElement element
    ) {
        final JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * click - overloaded method to execute a JavaScript click event using By.
     *
     * @param driver the driver
     * @param by     the by
     */
    public static void click(
        final WebDriver driver,
        final By by
    ) {
        final WebElement element = driver.findElement(by);

        final JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * sendKeys - method to execute a JavaScript value event.
     *
     * @param driver  the driver
     * @param keys    the keys
     * @param element the element
     */
    public static void sendKeys(
        final WebDriver driver,
        final String keys,
        final WebElement element
    ) {

        final JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + keys + "';", element);
    }

    /**
     * Scroll to element.
     *
     * @param driver  the driver
     * @param element the element
     */
    public static void scrollToElement(
        final WebDriver driver,

        final WebElement element
    ) {

        final JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView(true);",
            element
        );
    }

    /**
     * Scroll to middle element.
     *
     * @param driver  the driver
     * @param element the element
     */
    public static void scrollToMiddleOfElement(
        final WebDriver driver,
        final WebElement element
    ) {
        final JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript(
            "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
            element

        );
    }

}
