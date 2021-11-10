package com.zombieclothing.testCases;

import com.google.errorprone.annotations.ForOverride;
import com.zombieclothing.testCases.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class BaseTestListeners extends BaseClass
                                    implements ITestListener {

    public static boolean checkIfTestCaseIsPassed;
    public static boolean checkIfTestCaseIsFailed;
    public static boolean checkIfTestCaseIsSkipped;

    @ForOverride
    public void onFinish(ITestContext onFinishTestCase) {
        log.info("\n\nFinished the test case");
    }

    @ForOverride
    public void onStart(ITestContext onStartTestCase) {
        log.info("\n\nTest case was being started");
    }

    @ForOverride
    public void onTestFailedButWithinSuccessPercentage(ITestResult successPercent) {
        log.info("\n Test case's status: "+ successPercent.getStatus());
    }

    @Override
    public void onTestFailure(ITestResult failedTestCase) {
        System.out.println("\n Test case "+ failedTestCase.getName()+ " being failed!\n");
        checkIfTestCaseIsFailed=true;
    }

    @Override
    public void onTestSkipped(ITestResult skippedTestCase) {
        System.out.println("\n Test case "+ skippedTestCase.getName()+ " was flown! \n");
        checkIfTestCaseIsSkipped=true;
    }

    @Override
    public void onTestStart(ITestResult startedTestCase) {
        System.out.println("Test case "+ startedTestCase.getName()+ " was triggered!\n");
    }

    @ForOverride
    public void onTestSuccess(ITestResult passedTestCase) {
        System.out.println("\nTest case "+ passedTestCase.getName()+ " was successful!\n");
        checkIfTestCaseIsPassed=true;
    }
}
