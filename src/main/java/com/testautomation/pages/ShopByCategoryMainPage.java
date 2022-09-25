package com.testautomation.pages;
import com.testautomation.utility.CommonMethods;
import com.testautomation.utility.SynchronizationMethods;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testautomation.utility.JavaScriptMethods;

import java.util.List;
import java.util.stream.Collectors;


/**
 * The Class ShopByDepartmentCommonPage.
 */
public class ShopByCategoryMainPage {
    /** The driver. */

    private WebDriver driver;
    /** The sort by feature drop down. */

   private  By sortByFeatureDropdown = By.id("a-autoid-0-announce");

    /** The about this item section. */
    private  By aboutThisItemSection = By.xpath("//div[@id='feature-bullets']"
        +
        "//h1[text()=' About this item ']");

    /** The about this item section content list. */
    private  By aboutThisItemSectionContentList = By.xpath("//div[@id='feature-bullets']"
        +
        "//span[@class='a-list-item']");

    /**
     * Instantiates a new shop by department common page.
     *
     * @param newDriver the driver
     */
    public ShopByCategoryMainPage(final WebDriver newDriver) {

        this.driver = newDriver;

    }

    /**
     * Gets the sort by feature dropdown.
     *
     * @return the sort by feature dropdown
     */
    public By getSortByFeatureDropdown() {
        return sortByFeatureDropdown;
    }


    /**
     * Gets the about this item section.
     *
     * @return the about this item section
     */
    public By getAboutThisItemSection() {
        return aboutThisItemSection;
    }

    /**
     * Gets the item specific categoryName.
     *
     * @param categoryName the category name
     * @return the item specific feature
     */
    public WebElement getItemSpecificCategory(final String categoryName) {

        return driver
            .findElement(By.xpath("//span[text()= '" + categoryName + "']"));

    }

    /**
     * Gets the item specific feature.
     *
     * @param featureOption the feature option
     * @return the item specific feature
     */
    public By getSortByFeatureSpecificOption(final String featureOption) {

        return By.xpath("//div[@class = 'a-popover-wrapper']/descendant::a[text() = '" + featureOption + "']");

    }
    /**
     * Gets the item specific category locator.
     *
     * @param CategoryName the category name
     * @return the item specific category
     */
    public By getItemSpecificCategoryLocator(final String CategoryName) {

        return By.xpath("//span[text()= '" + CategoryName + "']");

    }

    /**
     * Filter product by category.
     *
     * @param categoryType the category type
     * @param categoryItem the category item
     */
    public void filterProductByCategory(
        final String categoryType,
        final String categoryItem) {

       SynchronizationMethods.fluentwait(
           driver,
           getItemSpecificCategoryLocator(categoryType),
           5000,
           5000);

        JavaScriptMethods.scrollToElement(
            driver,
            getItemSpecificCategory(categoryType)
        );

        getItemSpecificCategory(categoryItem).click();
    }
    /**
     *sort products by specific feature.
     *
     * @param featureTypeOption the feature type option
     */
    public void sortProductsByFeature(String featureTypeOption)
    {
        SynchronizationMethods.fluentwait(
            driver,
            getSortByFeatureDropdown(),
            5000,
            5000);

        CommonMethods.selectFromCustomDropDownMenu(
           driver,
          getSortByFeatureDropdown(),
            getSortByFeatureSpecificOption(featureTypeOption)
        );
    }

    /**
     * Select sorted product by index.
     *
     * @param index the index
     */
    public void selectSortedProductByIndex(final String index) {

     driver.findElement(By.cssSelector("div[data-index= '"
         + index + "']")).click();

    }

    /**
     * Display the about this item section content.
     * @return
     */
    public String displayAboutThisItemSectionContent() {
        List<String> aboutThisItemSectionContent =  driver.findElements(aboutThisItemSectionContentList).
            stream().map(element->element.getText()).collect(Collectors.toList());
        return String.join( System.getProperty("line.separator"), aboutThisItemSectionContent);

    }
}
