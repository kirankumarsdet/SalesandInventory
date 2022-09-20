package org.ar.genericUtility;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {

	@BeforeSuite
	public void suiteSetup()
	{
		//open database connection
		Reporter.log("@BeforeSuite", true);
	}
	@BeforeTest// when ever we executing in parallel with test ( 3 types of paral test)
	public void btest()
	{
		Reporter.log("@BeforeTest", true);
	}
	@BeforeClass
	public void classSetup()
	{
		Reporter.log("@BeforeClass", true);
		// inititalixe tge all utility class , read the data from the property file, common data, cretae the instance for browser, 
		//create the instance for browser(launch browser)
		//maximise, imp wait,
		//inititlize javascript executor,actionns, webdriver wait
		//cretae the instance for comoon object repo
	}
	@BeforeMethod
	public void methodSetup()
	{
		Reporter.log("@BeforeMethod", true);
		//login to application
		// whenevr we create the testcript vlass for module and testannotation method 
	}
	
	@Test
	public void test0()
	{
		Reporter.log("@Test", true);
	}
	@AfterMethod
	public void am()
	{
		Reporter.log("@AfterMethod", true);
	}
	@AfterClass
	public void ac()
	{
		Reporter.log("@AfterClass", true);
	}
	
	@AfterTest
	public void at()
	{
		Reporter.log("@AfterTest", true);
	}
	
	@AfterSuite
	public void as()
	{
		Reporter.log("@AfterSuite", true);
	}
	
}

