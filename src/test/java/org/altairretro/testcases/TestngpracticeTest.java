package org.altairretro.testcases;

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

public class TestngpracticeTest {

	@BeforeSuite
	public void bsuite()
	{
		Reporter.log("@BeforeSuite", true);
	}
	@BeforeTest
	public void btest()
	{
		Reporter.log("@BeforeTest", true);
	}
	@BeforeClass
	public void bclass()
	{
		Reporter.log("@BeforeClass", true);
	}
	@BeforeMethod
	public void bMethod()
	{
		Reporter.log("@BeforeMethod", true);
	}
	
	@Test
	public void test0()
	{
		Reporter.log("@Test", true);
	}
	@AfterSuite
	public void as()
	{
		Reporter.log("@AfterSuite", true);
	}
	@AfterTest
	public void at()
	{
		Reporter.log("@AfterTest", true);
	}
	@AfterClass
	public void ac()
	{
		Reporter.log("@AfterClass", true);
	}
	@AfterMethod
	public void am()
	{
		Reporter.log("@AfterMethod", true);
	}
}
