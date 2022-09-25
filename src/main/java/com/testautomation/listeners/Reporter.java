package com.testautomation.listeners;

import com.testautomation.utility.Browser;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import java.util.List;

public class Reporter implements IReporter {
    /**
     * Generating all reports.
     *
     * @param xmlSuites
     * @param suites
     * @param outputDirectory
     */
    @Override
    public void generateReport(
        final List<XmlSuite> xmlSuites,
        final List<ISuite> suites,
        final String outputDirectory
    ) {
        for (ISuite s : suites) {
            //Getting the results for the said suite
            for (ISuiteResult sr : s.getResults().values()) {
                // get the suit result context
                ITestContext tc = sr.getTestContext();

                // generate reports for passed tests
                for (ITestResult tr : tc.getPassedTests().getAllResults()) {
                    Browser.getReport().markAsPassed(tr);
                }

                // generate reports for failed tests
                for (ITestResult tr : tc.getFailedTests().getAllResults()) {
                    Browser.getReport().markAsFailed(tr);
                }

                // generate reports for failed config
                for (ITestResult tr : tc.getFailedConfigurations().getAllResults()) {
                    Browser.getReport().markAsFailed(tr, "CONFIG FAILURE");
                }
            }
        }

        // remove the dummy screenshot test from the final report page.
        Browser.getReport().removeScreenshotTest();

        // flushing— saving —the report content to disk.
        Browser.getReport().getExtent().flush();

        System.out.println("SUCCESS Reports generated");
    }
}
