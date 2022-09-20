package org.altairretro.testcases;

import org.ar.genericUtility.ExcelUtility;
import org.ar.genericUtility.FileUtility;
import org.ar.genericUtility.IConstantpath;
import org.ar.genericUtility.JavaUtility;
import org.ar.genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Admin_POS {
	public static void main(String[] args) throws InterruptedException {
		ExcelUtility Eu = new ExcelUtility(); // Object Creation for Utilities
		FileUtility Fu = new FileUtility();
		// JavaUtility Ju= new JavaUtility();
		WebDriverUtility WebD = new WebDriverUtility();
		String url  = Fu.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "url"); // Fetching Common datas from Property File
		String username = Fu.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "username");
		String password = Fu.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "password");
		String browser  = Fu.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "browser1");
		String SI_path  = Fu.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "SI_Path");
		Eu.initializeExcel(IConstantpath.EXCEL_PATH);
		String Product_Category = Eu.getdatafromExcel("Admin_POS", 2, 0); // Fetching Common
       WebD.si_login(username, password);																						// datas from Excel
																									// File
		String Product_Name = Eu.getdatafromExcel("Admin_POS", 2, 1);
		String Quantity = Eu.getdatafromExcel("Admin_POS", 2, 2);
		String Customer_name = Eu.getdatafromExcel("Admin_POS", 2, 3);
		WebDriver driver = WebD.openApplication(browser, url, 10);
		driver.findElement(By.xpath(SI_path)).click();
		WebD.si_login(username, password);
		driver.findElement(By.xpath("//span[text()='POS']")).click(); // Click on POS for transaction activities
		driver.findElement(By.xpath("//ul[@class='nav nav-tabs']/li/a[.='" + Product_Category + "']")).click(); // Category
																												// Selection
		WebElement ProdCat = driver
				.findElement(By.xpath("//ul[@class='nav nav-tabs']/li/a[.='" + Product_Category + "']"));
		String prodcategory = ProdCat.getText();
		/*
		 * driver.findElement(By.xpath("//h6[.='Newmen E120']")) driver.findElement(By.
		 * xpath("//h6[.='Newmen E120']/following-sibling::input[@value='1']"))
		 */
		WebElement productname = driver.findElement(By.xpath("//h6[.='" + Product_Name + "']"));
		String prodname = productname.getText();
		if (prodcategory.equalsIgnoreCase(Product_Category) && prodname.equalsIgnoreCase(Product_Name)) {
			WebElement quantity = driver
					.findElement(By.xpath("//h6[.='" + Product_Name + "']/following-sibling::input[@name='quantity']"));
			quantity.click();
			quantity.clear();
			quantity.sendKeys(Quantity);
		} else {
			System.out.println("Enter the correct product category and product name");
		}
		driver.findElement(By.xpath("//h6[.='Newmen E120']/following-sibling::input[@type='submit']")).click();

		String amttxt = driver.findElement(By.xpath(
				"//h4[.='Point of Sale']/following::div[@class='col-sm-5 text-primary']/following::input[@name='total']"))
				.getText();
		System.out.println(amttxt);
		WebElement selectcustomer = driver.findElement(By.name("customer"));
		selectcustomer.click();
		WebD.selectdropdown(selectcustomer, Customer_name);

		System.out.println(amttxt);
		driver.findElement(By.xpath("//button[.='SUBMIT']")).click();
		String amount = null;
		int count = 0;
		int duration = 10;
		while (count < duration) {
			try {
				amount = driver.findElement(By.xpath("//h3[@class='font-weight-bold py-3 bg-light']")).getText();
				if (amount.isEmpty()) {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				Thread.sleep(2000);
			}
		}
		System.out.println(amount);
		driver.findElement(By.xpath("//input[@placeholder='ENTER CASH']")).sendKeys(amount);
		driver.findElement(By.xpath("//button[.='PROCEED TO PAYMENT']")).click();
		WebD.alert();
		WebD.si_logout(); // logout
		WebD.si_login(username, password); // Re-login
		driver.findElement(By.xpath("//a[@href='transaction.php']")).click();
		WebElement LastCol = driver.findElement(By.xpath("//div[@id='dataTable_paginate']/descendant::li[last()-1]"));
		LastCol.click();
		WebElement lastele = driver.findElement(By.xpath("//tbody/tr[last()]/td[2]"));
		String lastOne = lastele.getText();
		if (lastOne.equalsIgnoreCase(Customer_name)) {
			System.out.println("TC is Passed");
			System.out.println(
					"Transaction Id is  " + (driver.findElement(By.xpath("//tbody/tr[last()]/td[1]")).getText()));
		} else {
			System.out.println("TC is Failed");
		}
		WebD.si_logout();
		driver.quit();
	}
}
