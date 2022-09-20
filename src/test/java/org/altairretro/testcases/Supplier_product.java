package org.altairretro.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Supplier_product {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/ai_commondata.Properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String SI_Path=p.getProperty("SI_Path");
		System.out.println(url);
		System.out.println(username);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(SI_Path)).click();
		String LoginPage = driver.findElement(By.xpath("//h1[.='Welcome to Sales and Inventory!']")).getText();
		//Login Page Validation
		if(LoginPage.equalsIgnoreCase("Welcome to Sales and Inventory!"))
		{
			System.out.println(LoginPage);
		System.out.println("LoginPage Displayed");
		}
		else
		{
			System.out.println("Click On ProperLink");
		}
		
	//Login to Application
		driver.findElement(By.xpath("//input[@name='user']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@name='btnlogin']")).click();
		driver.switchTo().alert().accept();
		String HomePage = driver.findElement(By.xpath("//div[text()='Sales and Inventory System']")).getText();
		System.out.println(HomePage);
		Assert.assertTrue(HomePage.equalsIgnoreCase("SALES AND INVENTORY SYSTEM"));
	
		driver.findElement(By.xpath("//span[.='Supplier']")).click();
		String SupplierPage = driver.findElement(By.xpath("//span[text()='Supplier']")).getText();
		
		if(SupplierPage.equalsIgnoreCase("Supplier"))
		{
			System.out.println("Supplier Page Displayed");
		}
		else
		{
			System.out.println("Supplier Page is not displayed");
		}
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
		WebElement Companyname = driver.findElement(By.name("companyname"));
		Companyname.click();
		Companyname.sendKeys("TyssTools");
		WebElement province_dd = driver.findElement(By.xpath("//h5[text()='Add Supplier']/ancestor::div[@class='modal-content']/descendant::select[@id='province']"));
		province_dd.sendKeys("Albay");
		//province_dd.click();
		//Select s = new Select(province_dd);
		//s.selectByVisibleText("Albay");
		WebElement city_dd = driver.findElement(By.xpath("//h5[text()='Add Supplier']/ancestor::div[@class='modal-content']/descendant::select[@id='city']"));
		//city_dd.click();
		city_dd.sendKeys("Libon");
		driver.findElement(By.xpath("//input=@placeholder='Phone Number'")).sendKeys("8951462015");
		//Select s1=new Select(city_dd);
		//s1.selectByVisibleText("Libon");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
