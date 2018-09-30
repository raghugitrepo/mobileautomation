package com.test.android.utils;

import java.io.IOException;

import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class TestListener extends General implements ITestNGListener {
	
	public void onTestFailure(ITestResult result) throws IOException {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	System.out.println(methodName);
    	takeScreenshotAtEndOfTest();
    }
	
}
