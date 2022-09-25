package com.testautomation.listeners;
import com.testautomation.reports.ExtentReportChrome;
import com.testautomation.utility.Browser;
import org.testng.IExecutionListener;

public class ExecutionListener implements IExecutionListener {

    /**
     * Run before all other listeners.
     */
    @Override
    public void onExecutionStart() {
        System.out.println("INFO: Starting tests execution.");
        // set up the extent report to be able to take screenshots.
        Browser.setReport(new ExtentReportChrome());
        Browser.getReport().setUp();
    }

    /**
     * Run after all other listeners.
     */
    @Override
    public void onExecutionFinish() {
        System.out.println("INFO: Execution completed.");

    }
}
