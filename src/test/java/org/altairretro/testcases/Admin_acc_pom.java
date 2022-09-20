package org.altairretro.testcases;

import java.util.List;

import org.ar.genericUtility.ExcelUtility;
import org.ar.genericUtility.FileUtility;
import org.ar.genericUtility.IConstantpath;
import org.ar.genericUtility.WebDriverUtility;
import org.ar.obejctrepo.CommonPage;
import org.ar.obejctrepo.CreateUser_Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Admin_acc_pom 
{
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
		String Employee = Eu.getdatafromExcel("AL_Account", 0, 1);
		String User_name = Eu.getdatafromExcel("AL_Account", 1, 1);
		String User_pwd = Eu.getdatafromExcel("AL_Account", 2, 1);
       WebDriver driver = WebD.openApplication(browser, url, 10);
       CommonPage CP= new CommonPage(driver);
       CreateUser_Account UserAcc = new CreateUser_Account(driver);
		CP.si();
		CP.Login();
		WebD.alert();
		UserAcc.userAccTab();
		String Admintext = UserAcc.adminAcc();
		if(Admintext.equalsIgnoreCase("Admin Account(s)"))
		{
		   UserAcc.clickonadduser();
		}
		UserAcc.Empl();
		WebD.selectdropdown(UserAcc.getEmpAddress(), Employee);
		UserAcc.us_name(User_name);
		UserAcc.pass_name(User_pwd);
		UserAcc.submitt();
		List<WebElement> elements = UserAcc.lisoff();
		int count =0;
		for ( WebElement ele : elements)
		{
			String eList = ele.getText();
			if(eList.equalsIgnoreCase(User_name))
			{
				System.out.println("TC is Passed");
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
		CP.profileclick();
	CP.quit();

	}
}

