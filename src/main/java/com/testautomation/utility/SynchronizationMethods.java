package com.testautomation.utility;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The Class SynchronizationMethods.
 */
public abstract class SynchronizationMethods {

    /**
     * Wait till element not visible.
     * @param driver          the driver
     * @param element         the element
     * @param timeoutInMillis the timeout in milliseconds
     */
    public static void waitTillElementNotVisible(
        final WebDriver driver,
        final WebElement element,
        final int timeoutInMillis
    ) {
      WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofMillis(timeoutInMillis));

        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    /**
     * Wait till element visible.
     *
     * @param driver          the driver
     * @param locator         the element
     * @param timeoutInMillis the timeout in milliseconds
     */
    public static void waitTillElementVisible(
        final WebDriver driver,
        final By locator,
        final int timeoutInMillis
    ) {

         WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofMillis(timeoutInMillis));

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    /**
     * Wait till element visible.
     *
     * @param driver          the driver
     * @param element         the element
     * @param timeoutInMillis the timeout in milliseconds
     */
    public static void waitTillElementVisible(
        final WebDriver driver,
        final WebElement element,
        final int timeoutInMillis
    ) {

         WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofMillis(timeoutInMillis));

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait till element is clickable.
     *
     * @param driver          the driver
     * @param element         the element
     * @param timeoutInMillis the timeout in seconds
     */
    public static void waitTillElementIsClickable(
        final WebDriver driver,
        final WebElement element,
        final int timeoutInMillis

    ) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeoutInMillis));

        wait.until(ExpectedConditions.elementToBeClickable(element));



    }
    /**
     * Wait till element is presented.
     *
     * @param driver          the driver
     * @param locator         the element locator
     * @param timeoutInMillis the timeout in seconds
     */
    public static void waitTillElementIsPresented(
        final WebDriver driver,
        final By locator,
        final int timeoutInMillis

    ) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeoutInMillis));


        wait.until(ExpectedConditions.presenceOfElementLocated(locator));


    }

    /**
     * Wait till element attribute changed.
     *
     * @param driver          the driver
     * @param element         the element
     * @param attributeName   the attribute name
     * @param value           the value
     * @param timeoutInMillis the timeout in millis
     */
    public static void waitTillElementAttributeContains(
        final WebDriver driver,
        final WebElement element,
        final String attributeName,
        final String value,
        final int timeoutInMillis

    ) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeoutInMillis));

        wait.until(ExpectedConditions.attributeContains(element, attributeName, value));

    }

    /**
     * Wait till element text is presented.
     *
     * @param driver          the driver
     * @param element         the element
     * @param textValue       the text value
     * @param timeoutInMillis the timeout in millis
     */
    public static void waitTillElementTextIsPresented(
        final WebDriver driver,
        final WebElement element,
        final String textValue,
        final int timeoutInMillis

    ) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeoutInMillis));

        wait.until(ExpectedConditions.textToBePresentInElement(element, textValue));

    }

    /**
     * Wait till iframe is loaded and switch to it.
     *
     * @param driver          the driver
     * @param frame           the frame
     * @param timeoutInMillis the timeout in millis
     */
    public static void waitTillIframeIsLoadedAndSwitchToIt(
        final WebDriver driver,
        final WebElement frame,
        final int timeoutInMillis

    ) {

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeoutInMillis));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));

    }

    /**
     * Wait till visibility of all elements.
     *
     * @param driver          the driver
     * @param elements        the elements
     * @param timeoutInMillis the timeout in millis
     */
    public static void waitTillVisibilityOfAllElements(
        final WebDriver driver,
        final List<WebElement> elements,
        final int timeoutInMillis
    ) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeoutInMillis));

        wait.until(ExpectedConditions.visibilityOfAllElements(elements));

    }
    /**
     * Wait till visibility of all elements.
     *
     * @param driver          the driver
     * @param locator        the element locator
     * @param waitTimeoutInMillis the timeout in millis
     * @param pollingTimeoutInMillis the timeout in millis
     */
    public static void fluentwait(
        final  WebDriver driver,
        final  By locator,
        final int waitTimeoutInMillis,
        final int pollingTimeoutInMillis){

        FluentWait wait  = new FluentWait(driver)
            .withTimeout(Duration.ofMillis(waitTimeoutInMillis))
            .pollingEvery(Duration.ofMillis(pollingTimeoutInMillis)).ignoring(NoSuchElementException.class);

        WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(final WebDriver driver) {
                return driver.findElement(locator);
            }
        });

    }




}
