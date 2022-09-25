package com.testautomation.tests;

import static org.testng.Assert.assertTrue;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.testautomation.pages.AmazonHomePage;
import com.testautomation.pages.TelevsionsPage;
import com.testautomation.utility.Browser;
import com.testautomation.utility.CommonMethods;
import com.testautomation.utility.TestDataProvider;

/**
 * The Class ShopByDeptAboutThisItemSectionTest.
 */
public class TelevisionAboutThisItemSectionTest extends TestBase {

    /** The amazon home page. */
    private AmazonHomePage amazonHomePage;

    /** The televisions page. */
    private TelevsionsPage televsionsPage;

    /**
     * Select and check product AboutThisItem Section.
     *
     * @param testData the test data
     */
    @Test(description = "Verify that about this item section page is shown correctly " +
        "after a user choose a specific product (television) from Amazon Shop By Department menu ",
        dataProviderClass = TestDataProvider.class,
        dataProvider = "Shop-By-Category-Test-Data")
    public void selectAndCheckProductAboutThisItemSection(final HashMap<String, String> testData) {
        Browser.getReport().reportLog("Open “Hamburger menu” from amazon home page");
        amazonHomePage.openHamburgerMenu();

        Browser.getReport().reportLog("scroll down to shop by category section and select the TV, Appliances and Electronics link.");
        amazonHomePage.selectSubmenuFromHamburgerMenuSections(
            testData.get("Section"),
            testData.get("SubmenuLink"));

        Browser.getReport().reportLog("Form “Tv, Audio & Cameras” subsection select “Televisions” item.");
        amazonHomePage.selectItemFromSubsection(
            testData.get("Subsection"),
            testData.get("ItemName"));

        Browser.getReport().reportLog("in Television page, Scroll down and filter the results by Brand “Samsung”.");
        televsionsPage.filterProductByCategory(
            testData.get("BrandsCategoryList"),
            testData.get("BrandName"));

        Browser.getReport().reportLog("Sort the Samsung results with “price High to Low”.");
        televsionsPage.sortProductsByFeature(testData.get("SortByFeatureOption"));

        Browser.getReport().reportLog("Select the second highest priced item from the shown sorted television items.");
        televsionsPage.selectSortedProductByIndex(testData.get("ProductIndex"));

        Browser.getReport().reportLog("Switch to the second Highest priced television item page.");
        Browser.switchTabs(getDriver(), Browser.getCurrentTab(getDriver()) + 1);

        Browser.getReport().reportLog("Check that “About this item” section is shown. ");
        assertTrue(CommonMethods.elementIsPresented(getDriver(),televsionsPage.getAboutThisItemSection()),
            "About this item section is not presented in the page.");

        Browser.getReport().reportLog( televsionsPage.displayAboutThisItemSectionContent());

    }

    /**
     * Before class.
     */
    @Override
    @BeforeClass()
    public void beforeClass() {

        amazonHomePage = new AmazonHomePage(getDriver());
        televsionsPage = new TelevsionsPage(getDriver());

    }
}
