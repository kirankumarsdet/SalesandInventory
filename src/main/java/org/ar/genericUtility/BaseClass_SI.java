package org.ar.genericUtility;

import static org.testng.Assert.assertEquals;

import org.ar.obejctrepo.CommonPage;
import org.ar.obejctrepo.CreateUser_Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass_SI {
	protected WebDriver driver;
	protected WebDriverUtility webdriver;
	protected ExcelUtility excelutility;
	protected FileUtility fileutility;
	protected CommonPage cp;
	private CreateUser_Account ua;
	public static WebDriver sdriver;

	@Parameters/*(value="browser")*/
	@BeforeClass
	public void classSetup(/*String browser*/) {
		webdriver = new WebDriverUtility();
		excelutility = new ExcelUtility();
		fileutility = new FileUtility();
		excelutility.initializeExcel(IConstantpath.EXCEL_PATH);

	String browser = fileutility.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "browser1");
		String url = fileutility.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "url");
		driver = webdriver.openApplication(browser, url, 10);
		sdriver=driver;
		cp = new CommonPage(driver);
		String LoginPage = driver.findElement(By.xpath("//h1[.='Welcome to Sales and Inventory!']")).getText();
		assertEquals(LoginPage, "Welcome to Sales and Inventory!");
		String username = fileutility.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "username");
		String password = fileutility.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "password");
		webdriver.si_login(username, password);
		String hometxt = cp.HomePageText();
		System.out.println(hometxt);
		assertEquals(hometxt,"SALES AND INVENTORY SYSTEM");
		
		/* String popuptxt = driver.switchTo().alert().getText();
		 assertEquals(popuptxt,("prince Welcome!"));
		 webdriver.alert();*/
		 /*{
			System.out.println("Login Successfull");
		} else {
			System.out.println("Login UnSuccessfull Check Username or Password");
		}*/

	}

	@AfterClass
	public void classTeardown() {
		excelutility.closeExcel();
		cp.profileclick();
		cp.quit();
		
	}
	}

