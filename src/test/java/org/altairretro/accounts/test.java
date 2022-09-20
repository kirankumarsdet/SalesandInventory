package org.altairretro.accounts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
	public static void main(String[] args) throws Throwable, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		FileInputStream fis=new FileInputStream("./src/test/resources/SI.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet2");
		String Thead=sheet.getRow(0).getCell(0).getStringCellValue();
		String Username=sheet.getRow(0).getCell(1).getStringCellValue();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Sales_And_Inventory_..>']")).click();
		driver.findElement(By.name("user")).sendKeys("unguardable");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("btnlogin")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//span[.='Accounts']")).click();
		driver.findElement(By.xpath("//a[@data-target='#supplierModal']")).click();
		WebElement drop = driver.findElement(By.xpath("//select[@name='empid']"));
		drop.click();
		Select s=new Select(drop);
		s.selectByIndex(2);
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='username' and @placeholder='Username']")).sendKeys(Username);
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='password'and @placeholder='Password']")).sendKeys("swa123");
		driver.findElement(By.xpath("//h5[.='Add User Account']/following::button[.='Save']")).click();
		String validation = driver.findElement(By.xpath("//h4[contains(.,'User')]/following::th[.='"+Thead+"' ]/ancestor::thead/following-sibling::tbody/tr/td[contains(.,'"+Username+"')]")).getText();
		System.out.println(validation);
		if(Username.equalsIgnoreCase(validation))
		{
			System.out.println("Test Case Pass");	
		}
		else
		{
			System.out.println("Test Case Fail");	
		}
	}
}
