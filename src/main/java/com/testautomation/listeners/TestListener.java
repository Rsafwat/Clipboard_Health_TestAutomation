package com.testautomation.listeners;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    /**
     * On test success.
     * @param result the result
     */
    @Override
    public void onTestSuccess(final ITestResult result) {
        System.out.println(
            result.getTestClass().getName()
                + "::"
                + result.getName()
                + (" PASS ")
                + "Execution Time= "
                + (result.getEndMillis() - result.getStartMillis())
                + " milli sec"
        );
    }

    /**
     * On test failure.
     *
     * @param result the result
     */
    @Override
    public void onTestFailure(final ITestResult result) {
        System.out.println(
            result.getTestClass().getName()
                + "::"
                + result.getName()
                + (" FAIL ")
                + "Execution Time= "
                + (result.getEndMillis() - result.getStartMillis())
                + "milli sec"
        );
    }

    /**
     * On test skipped.
     *
     * @param result the result
     */
    @Override
    public void onTestSkipped(final ITestResult result) {
        System.out.println(
            result.getTestClass().getName()
                + "::"
                + result.getName()
                + (" SKIP ")
        );
    }
}
