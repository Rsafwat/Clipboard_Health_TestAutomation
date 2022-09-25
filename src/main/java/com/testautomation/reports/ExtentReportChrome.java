package com.testautomation.reports;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.aventstack.extentreports.Status;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testautomation.utility.Browser;
import org.testng.Reporter;

/**
 * The Class ExtentReportListener_Chrome.
 */
public class ExtentReportChrome {

    /**
     * A dummy extent test for taking screenshot. It is not included in the final
     * report.
     */
    private ExtentTest screenshots;
    private ExtentTest test;

    /**
     * Abs path to the test screenshots.
     */
    public static final String TARGET_SCREENSHOTS_ABS_PATH = System.getProperty("user.dir")
        + "/target/screenshots."
        + Browser.getPropertiesFile().getProperty("test.target.browser")
        + "/";

    /**
     * Relative path to the test screenshots.
     */
    public static final String TARGET_SCREENSHOTS_RELATIVE_PATH = "screenshots."
        + Browser.getPropertiesFile().getProperty("test.target.browser")
        + "/";
    /**
     * Abs path to the test reports.
     */
    public static final String TARGET_REPORT_ABS_PATH = System.getProperty("user.dir")
        + "/target/reports."
        + Browser.getPropertiesFile().getProperty("test.target.browser")
        + "/";
    /**
     * Relative path to the test reports.
     */
    public static final String TARGET_REPORT_RELATIVE_PATH = "reports."
        + Browser.getPropertiesFile().getProperty("test.target.browser")
        + "/";

    /**
     *
     * /** The extent.
     */
    private static ExtentReports extent = null;

    /**
     * Gets the extent.
     *
     * @return the extent
     */
    public ExtentReports getExtent() {
        return ExtentReportChrome.extent;
    }

    /**
     * Sets the Extent Reports up.
     *
     * @return the extent reports
     */
    public ExtentReports setUp() {
        final ExtentHtmlReporter report = new ExtentHtmlReporter("./target/report.chrome.html");
        report.config().setDocumentTitle("Automation Test Report");
        report.config().setReportName("Automation Test Report");
        report.config().setTheme(Theme.STANDARD);
        report.start();

        extent = new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("SW Version ", "x.x ");
        extent.setSystemInfo("browser", "Google Chrome");
        extent.setSystemInfo("Tester Name", "Rokaya Safwat");

        screenshots = extent.createTest("Screenshots");
        final File target = new File(TARGET_SCREENSHOTS_ABS_PATH);
        if (!target.exists()) {
            target.mkdirs();
        }

        System.out.println(

            " Extent report initialized."
        );

        return extent;
    }
    /**
     * create test on start execution.
     *
     * @return the extent test
     */
public ExtentTest CreateTestStart(String testName)
{
    test= extent.createTest(testName);
    return test;
}
    /**
     * Construct the failure message.
     *
     * @param result test result.
     * @param label  label message.
     */
    private void createTestFailure(final ITestResult result, final String label) {
        test.fail(
            MarkupHelper.createLabel(label, ExtentColor.RED).getMarkup()
                + " Settings: "
                + Arrays.toString(result.getParameters())
                + "\nAn exception is thrown with message:"
                + MarkupHelper.createCodeBlock(
                ExceptionUtils.getMessage(result.getThrowable()) + "\n"
                    + ExceptionUtils.getStackTrace(result.getThrowable())
            ).getMarkup()
        );

        // Attach screenshots to failed test
        try {
            test.fail(
                "<b><font color=red>Screenshot</font></b>",
                MediaEntityBuilder.createScreenCaptureFromPath(
                    TARGET_SCREENSHOTS_RELATIVE_PATH
                        + (label.equals("CONFIG FAILURE") ? "config.failure." : "")
                        + getScreenshotFileName(result, ".png")
                ).build()

            );
        } catch (final IOException e) {
            System.out.println(

                " Cannot attach screenshot."
            );
        }
    }

    /**
     * Marking the test as failed.
     *
     * @param result test result.
     */
    public void markAsFailed(final ITestResult result) {
        createTestFailure(result, "FAIL");
    }

    /**
     * Marking the test as failed.
     *
     * @param result test result.
     * @param label  label text.
     */
    public void markAsFailed(final ITestResult result, final String label) {
        createTestFailure(result, label);
    }

    /**
     * Mark test as pass.
     *
     * @param result test result.
     */
    public void markAsPassed(final ITestResult result) {
        test

            .pass(
                MarkupHelper.createLabel("PASS", ExtentColor.GREEN).getMarkup()
                    + " "
                    + result.getMethod().getDescription()
                    + " "
                    + "Settings: "
                    + Arrays.toString(result.getParameters())
            );
    }

    /**
     * Mark test as skip.
     *
     * @param result test result.
     */
    public void markAsSkipped(final ITestResult result) {

            test.skip(
                MarkupHelper.createLabel("SKIP", ExtentColor.YELLOW).getMarkup()
            );
    }

    /**
     * Capture screen shot.
     *
     * @param driver       the driver
     * @param testcaseName the testcase name
     * @return the string
     */
    public String captureScreenShot(
        final WebDriver driver,
        final String testcaseName
    ) {
        final TakesScreenshot screen = (TakesScreenshot) driver;
        final File src = screen.getScreenshotAs(OutputType.FILE);
        final String dest = TARGET_SCREENSHOTS_ABS_PATH + testcaseName + ".png";
        final File target = new File(dest);
        try {
            FileUtils.copyFile(src, target);
        } catch (final IOException e) {
            System.out.println(

                " Failed to copy screenshot file."
                    + ExceptionUtils.getMessage(e)
                    + "\n"
                    + ExceptionUtils.getStackTrace(e)
            );
            return null;
        }
        target.setReadable(true, false);
        target.setWritable(true, false);
        return dest;
    }

    /**
     * Take screenshot in the test.
     *
     * @param driver       web driver
     * @param testcaseName screenshot filename
     */
    public void takeScreenShot(
        final WebDriver driver,
        final String testcaseName
    ) {
        try {
            screenshots.addScreenCaptureFromPath(
                captureScreenShot(driver, testcaseName)
            );
        } catch (final IOException e) {
            System.out.println(

                " Failed to add screen capture from path."
                    + ExceptionUtils.getMessage(e)
                    + "\n"
                    + ExceptionUtils.getStackTrace(e)
            );
        }
    }

    /**
     * Remove the screenshots dummy test from the Chrome report.
     */
    public void removeScreenshotTest() {
        extent.removeTest(screenshots);
    }

    /**
     * Construct formatted test screenshot filename.
     *
     * @param result
     * @param fileExtension
     * @return screenshot file name
     */
    public String getScreenshotFileName(final ITestResult result, final String fileExtension) {
        return result.getTestClass().getName() + fileExtension;
    }

    /**
     * report test messages to Report.
     *
     * @param message test message.
     */
    public void reportLog(String message) {
        test.log(Status.INFO,message);

    }

}
