package com.automation.base;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.driver.Driver;

public class BaseTest {
	
	protected BaseTest() {}

	@BeforeMethod
	protected void setUp(Object[] data) throws Exception { 
		Map<String,String> map = (Map<String,String>)data[0];
		Driver.initDriver(map.get("browser"), map.get("version"));
	}
	
	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}

}
