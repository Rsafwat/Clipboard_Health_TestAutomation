package com.testautomation.pages;

import com.testautomation.utility.CommonMethods;
import com.testautomation.utility.SynchronizationMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testautomation.utility.JavaScriptMethods;

/**
 * The Class AmazonHome.
 */
public class AmazonHomePage  {
    /** The driver. */
    private WebDriver driver;
    /** The hamburger main menu. */
    private By hamburgerMainMenu = By.id("nav-hamburger-menu");

    /**
     * Instantiates a new home.
     *
     * @param newDriver the driver
     */
    public AmazonHomePage(final WebDriver newDriver) {

        this.driver = newDriver;

    }


    /**
     * Gets the hamburger menu.
     *
     * @return the hamburger menu
     */
    public By getHamburgerMenu() {
        return hamburgerMainMenu;
    }


    /**
     * Gets the hamburger specific menu.
     *
     * @param section the specific section name
     * @return the hamburger specific section
     */
    public WebElement getHamburgerSpecificSection(final String section) {

        return driver
            .findElement(By.xpath("//div[@id = 'hmenu-content']"
                +
                "/descendant::div[text() = '" + section + "']"));

    }
    /**
     * Gets the hamburger specific Section locator.
     *
     * @param section the specific section name
     * @return the hamburger specific submenu
     */
    public By getHamburgerSpecificSectionLocator(final String section) {

        return By.xpath("//div[@id = 'hmenu-content']"
            +
            "/descendant::div[text() = '" + section + "']");

    }

    /**
     * Gets the hamburger menu specific item.
     *
     * @param itemName the item name
     * @return the hamburger menu specific item
     */
    public WebElement getHamburgerMenuSpecificItem(final String itemName) {

        return driver
            .findElement(By.xpath("//div[@id = 'hmenu-content']"
                +
                "/descendant::a[text() = '" + itemName + "']"));
    }


    /**
     * Open hamburger menu.
     */
    public void openHamburgerMenu() {

        driver.findElement(hamburgerMainMenu).click();
    }


    /**
     * Select submenu from hamburger menu sections.
     *
     * @param section the section
     * @param submenu the submenu
     */
    public void selectSubmenuFromHamburgerMenuSections(
        final String section,
        final String submenu
    ) {
        SynchronizationMethods.waitTillElementIsPresented(
            driver,
            getHamburgerSpecificSectionLocator(section),
            5000);
        JavaScriptMethods.scrollToElement(
            driver,
            getHamburgerSpecificSection(section)
        );

        getHamburgerSpecificSection(submenu).click();
    }


    /**
     * Select item from subsection.
     *
     * @param subsection the subsection
     * @param item the item
     */
    public void selectItemFromSubsection(
        final String subsection,
        final String item) {
        SynchronizationMethods.waitTillElementIsPresented(
            driver,
            getHamburgerSpecificSectionLocator(subsection),
            5000);
        JavaScriptMethods.scrollToElement(
            driver,
            getHamburgerSpecificSection(subsection)
        );
        getHamburgerMenuSpecificItem(item).click();
    }

}
