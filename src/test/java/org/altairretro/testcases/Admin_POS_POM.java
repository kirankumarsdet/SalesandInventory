package org.altairretro.testcases;

import org.ar.genericUtility.ExcelUtility;
import org.ar.genericUtility.FileUtility;
import org.ar.genericUtility.IConstantpath;
import org.ar.genericUtility.WebDriverUtility;
import org.ar.obejctrepo.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Admin_POS_POM {

	public static void main(String[] args) {

		ExcelUtility Eu = new ExcelUtility(); // Object Creation for Utilities
		FileUtility Fu = new FileUtility();
		// JavaUtility Ju= new JavaUtility();
		WebDriverUtility WebD = new WebDriverUtility();
		String url = Fu.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "url"); // Fetching Common datas from Property File
		String username = Fu.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "username");
		String password = Fu.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "password");
		String browser = Fu.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "browser1");
		//String SI_path = Fu.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "SI_Path");
		Eu.initializeExcel(IConstantpath.EXCEL_PATH);
		String Product_Category = Eu.getdatafromExcel("Admin_POS", 2, 0); // Fetching Common
		// datas from Excel
		// File
		String Product_Name = Eu.getdatafromExcel("Admin_POS", 2, 1);
		String Quantity = Eu.getdatafromExcel("Admin_POS", 2, 2);
		System.out.println(Quantity);
		String Customer_name = Eu.getdatafromExcel("Admin_POS", 2, 3);
		WebDriver driver = WebD.openApplication(browser, url, 10);
		//driver.findElement(By.xpath(SI_path)).click();
		CommonPage CP = new CommonPage(driver);
		CP.Login();
		WebD.alert();
		CP.POStab();
		WebElement ele = CP.convertStringToWebelement(Product_Category);
		CP.clickonDynamicEle(ele);
		WebElement ele1 = CP.prodname(Product_Name);
		CP.clickonDynamicEle(ele1);
		CP.sendData(ele1, Quantity);
		CP.clickonDynamicEle(ele1);
		WebElement addbut = CP.addbutton(Product_Name);
		CP.addpro(Product_Name, addbut);
		WebElement cust = CP.customer();
		WebD.selectdropdown(cust, Customer_name);
		CP.submit();
		String amount = null;
		int count = 0;
		int duration = 10;
		while (count < duration) {
			try {
				amount = CP.amt();
				System.out.println(amount);
				if (amount.isEmpty()) {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		CP.cash(amount);
		CP.pay();
		WebD.alert();
		CP.profileclick();
		CP.Login();
		WebD.alert();
		CP.trans();
		CP.lastcol();
		CP.lastone();
		String kkkkk = CP.lastone();
		if (kkkkk.equalsIgnoreCase(Customer_name)) {
			System.out.println("TC is Passed");
			CP.trans1();
		} else {
			System.out.println("TC is failed");
		}
		CP.profileclick();
		CP.quit();
	}
}