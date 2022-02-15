package com.automation.reports;

import com.aventstack.extentreports.ExtentTest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExtentManager {

	private static final ThreadLocal<ExtentTest> extTest = new ThreadLocal<>() ;

	public static ExtentTest getExtentTest() { //default --> it can be only accessed within the package --> private packages
		return extTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}

	static void unload() {
		extTest.remove();
	}
}
