package org.altairretro.accounts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.ar.genericUtility.GetdatafromExcel;
import org.ar.genericUtility.IConstantpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fetchdatafrompropertyfile {

	public static void main(String[] args) throws IOException, InterruptedException

	{

		// step1--> convert physical file into java readable Object
		FileInputStream fis = new FileInputStream("./src/test/resources/ai_commondata.Properties");
		// Step 2--> Create Object for Propertie
		Properties p = new Properties();
		// Load all the keys
		p.load(fis);
		// fetch data
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		System.out.println(url);
		System.out.println(username);

		//Fetching data frpm excel file

		FileInputStream fisexcel = new FileInputStream("./src/test/resources/SI.xlsx");
		Workbook wb = WorkbookFactory.create(fisexcel);

		String uname = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
	     // String uname = new GetdatafromExcel().getDataFromExcel(IConstantpath.EXCEL_PATH,"Sheet1", 1, 2);
	      //System.out.println(uname);
		String pwd = wb.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
	      //String pwd = new GetdatafromExcel().getDataFromExcel(IConstantpath.EXCEL_PATH,"Sheet1", 2, 2);
        //System.out.println(pwd);
		/*
		 * get all values from excel Sheet sheet = wb.getSheet("Sheet1"); int lastrow1=
		 * sheet.getLastRowNum(); int lastcell=4; for (int i=1;i<=lastrow1;i++) {
		 * for(int j=0;j<=lastcell;j++) { Row row = sheet.getRow(i); Cell cell =
		 * row.getCell(j); String usernam = cell.getStringCellValue();
		 * System.out.println(usernam+ "   ||   "); } System.out.println(); }
		 */

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Sales_And_Inventory_..>']")).click();
		String title = driver.getTitle();
		System.out.println(title + " page is opened");
		if (title.equals("Sales And Inventory")) {
			System.out.println("Sales and Inventory Login is displayed");
		} else {
			System.out.println("Click on the correct link Page");
		}
		driver.findElement(By.name("user")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnlogin")).click();

		if (driver.switchTo().alert().getText().equalsIgnoreCase("prince Welcome!")) {
			System.out.println("Admin Successfully Logged in");
		} else {
			System.out.println("Admin Entered wrong credentials");
		}
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//span[text()='Accounts']")).click();

		String acc = driver.findElement(By.xpath("//h4[text()='Admin Account(s)']")).getText();
		if (acc.equalsIgnoreCase("Admin Account(s)")) {
			System.out.println(acc + "  page is opened");
		} else {
			System.out.println("click on the accounts module");
		}
		System.out.println(uname + "user name from excel");
		System.out.println(pwd + "pwd from excel");

		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
		WebElement empdd = driver.findElement(By.name("empid"));
		Select s = new Select(empdd);
		s.selectByIndex(12);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='username' and @placeholder='Username']"))
				.sendKeys(uname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='password'and @placeholder='Password']"))
				.sendKeys(pwd);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])[5]")).click();
		driver.findElement(By.id("userDropdown")).click();
		driver.findElement(By.xpath("//a[@data-toggle='modal' and @data-target='#logoutModal']")).click();
		driver.findElement(By.xpath("//div[@class='modal-footer'] //a[text()='Logout']")).click();
		String lgin = driver.findElement(By.xpath("//h1[text()='Welcome to Sales and Inventory!']")).getText();
		if (lgin.equalsIgnoreCase("Welcome to Sales and Inventory!")) {
			System.out.println(lgin);
			System.out.println("Logout Succesfull");

		} else {
			System.out.println("Logout UnSuccesfull");
		}
		driver.quit();
		/*
		 * JavascriptExecutor js= (JavascriptExecutor)driver;
		 * js.executeScript("window.scrollBy(0,100000);");
		 */
	}
}
