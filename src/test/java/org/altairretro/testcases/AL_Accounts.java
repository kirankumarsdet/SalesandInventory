package org.altairretro.testcases;

import java.util.List;

import org.ar.genericUtility.ExcelUtility;
import org.ar.genericUtility.FileUtility;
import org.ar.genericUtility.IConstantpath;
import org.ar.genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AL_Accounts {

	public static void main(String[] args) {
		ExcelUtility Excel = new ExcelUtility();
		FileUtility File = new FileUtility();
		WebDriverUtility WebD = new WebDriverUtility();

		// fetching common dats from property file
		String url = File.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "url");
		String username = File.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "username");
		String password = File.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "password");
		String browser = File.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "browser1");
		String SI_path = File.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH, "SI_Path");
		// String Acc_mod =
		// File.FetchUrl(IConstantpath.PROPERTY_FILE_XPATH,"Ac_module")
		// fetching data from excel
		Excel.initializeExcel(IConstantpath.EXCEL_PATH);
		String Employee = Excel.getdatafromExcel("AL_Account", 0, 1);
		String User_name = Excel.getdatafromExcel("AL_Account", 1, 1);
		String User_pwd = Excel.getdatafromExcel("AL_Account", 2, 1);
        WebDriver driver = WebD.openApplication(browser, url, 10);
		driver.findElement(By.xpath(SI_path)).click();
		driver.findElement(By.name("user")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnlogin")).click();
		WebD.alert();
		driver.findElement(By.xpath("//span[text()='Accounts']")).click();
		String acc = driver.findElement(By.xpath("//h4[text()='Admin Account(s)']")).getText();
		if (acc.equalsIgnoreCase("Admin Account(s)")) { 
			System.out.println(acc + "  page is opened");
		} else {
			System.out.println("click on the accounts module");
		}
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
		WebElement empdd = driver.findElement(By.name("empid"));
		empdd.click();
		WebD.selectdropdown(empdd, Employee);
		WebElement U_name = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='username' and @placeholder='Username']"));
		U_name.sendKeys(User_name);
		//String User = U_name.getText();
		//System.out.println(User_name);
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='password'and @placeholder='Password']"))
				.sendKeys(User_pwd);
		driver.findElement(By.xpath("//h5[.='Add User Account']/following::button[@type='submit']")).click();
		List<WebElement> elements = driver
				.findElements(By.xpath("//h4[contains(.,'User')]/../following::tbody//td[2]"));
		int count = 0;
		for (WebElement tabledata : elements)
		{
			String Usernames = tabledata.getText();
			System.out.println(Usernames);
			if (Usernames.equalsIgnoreCase(User_name))
			{
				System.out.println("TC is Passes");
				count++;
				break;
			}
			if (count == 1) 
			{
				break;

			}
		}
		if (count == 0) 
		{
			System.out.println("tc is fail");
		}

	}
}
/*
 * else { System.out.println("Test Case Is failed"); break;
 * 
 * }
 */
