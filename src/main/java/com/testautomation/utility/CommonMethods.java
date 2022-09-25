package com.testautomation.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * The Class CommonMethods.
 */
public abstract class CommonMethods {

    /**
     * Element is presented.
     *
     * @param driver the driver
     * @param locator     the by locator
     * @return true, if successful
     */
    public static boolean elementIsPresented(
        final WebDriver driver,
        final By locator) {

        return driver.findElement(locator).isDisplayed();


    }


    /**
     * Select from drop down menu.
     *
     * @param driver   the driver
     * @param dropDown the drop down
     * @param option   the option
     */
    public static void selectFromDropDownMenu(
        final WebDriver driver,
        final By dropDown,
        final String option
    ) {
        final Select dropdownMenu = new Select(driver.findElement(dropDown));
        dropdownMenu.selectByVisibleText(option);
    }

    /**
     * Select from drop down menu. - overloaded method to execute select event using
     * WebElement.
     *
     * @param dropDown the drop down
     * @param option   the option
     */
    public static void selectFromDropDownMenu(
        final WebElement dropDown,
        final String option
    ) {

        final Select dropdownMenu = new Select(dropDown);
        dropdownMenu.selectByVisibleText(option);
    }

    /**
     * Select from custom drop down menu.
     * @param driver   the driver
     * @param dropdownMenu the dropdown menu
     * @param option       the option
     */
    public static void selectFromCustomDropDownMenu(
        final WebDriver driver,
        final By dropdownMenu,
        final By option
    ) {

        clicKOnWebElement(driver, dropdownMenu);
      clicKOnWebElement(driver, option);
    }

    /**
     * Check element css value.
     *
     * @param element      the element
     * @param propertyName the property name
     * @param value        the value
     * @return true, if successful
     */
    public static boolean checkElementCssValue(
        final WebElement element,
        final String propertyName,
        final String value
    ) {
        return element.getCssValue(propertyName).contains(value);
    }

    /**
     * Check Element attribute value.
     *
     * @param element       the element
     * @param attributeName the attribute name
     * @param value         the value
     * @return true, if successful
     */
    public static boolean checkElementAtrributeValue(
        final WebElement element,
        final String attributeName,
        final String value
    ) {
        return element.getAttribute(attributeName).contains(value);
    }

    /**
     * Mouse hover on element.
     *
     *
     * @param driver  the driver
     * @param element the element
     */
    public static void mouseHoverOnElement(
        final WebDriver driver,
        final WebElement element
    ) {
        final Actions actions = new Actions(driver);
        // Mouse hover on element
        actions.moveToElement(element).perform();

    }


    /**
     * click on web element.
     *
     * @param driver the driver
     * @param locator     locator
     * */
    public static void clicKOnWebElement(
        final WebDriver driver,
        final By locator

    ) {
        driver.findElement(locator).click();
    }
    /**
     * get element Text.
     *
     * @param driver         the driver
     * @param locator the locator
     * @return true, if successful
     */
    public static String getWebElementText(
        final WebDriver driver,
        final By locator) {
       return driver.findElement(locator).getText();

    }
/**
 * get element Text.
 * @param element the element
 * @return text of the web element
 */
public static String getWebElementText(final WebElement element) {
        return element.getText();

    }
}
